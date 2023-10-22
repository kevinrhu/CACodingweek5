package use_case.clear_users;

// TODO Complete me

import entity.User;

public class ClearInteractor {
    final ClearUserDataAccessInterface userDataAccessObject;
    final ClearOutputBoundary clearPresenter;

    public ClearInteractor(ClearUserDataAccessInterface userDataAccessInterface,
                           ClearOutputBoundary clearOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.clearPresenter = clearOutputBoundary;
    }

    @Override
    public void execute(ClearInputData clearInputData) {
        String username = clearInputData.getUsername();
        String password = clearInputData.getPassword();
        if (!userDataAccessObject.existsByName(username)) {
            clearPresenter.prepareFailView(username + ": Account does not exist.");
        } else {
            String pwd = userDataAccessObject.get(username).getPassword();
            if (!password.equals(pwd)) {
                clearPresenter.prepareFailView("Incorrect password for " + username + ".");
            } else {

                User user = userDataAccessObject.get(clearInputData.getUsername());

                ClearOutputData clearOutputData = new ClearOutputData(user.getName(), false);
                clearPresenter.prepareSuccessView(clearOutputData);
            }
        }
    }
}
