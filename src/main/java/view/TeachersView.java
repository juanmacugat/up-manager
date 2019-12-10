package view;

import presenter.TeachersPresenter;

public class TeachersView {
    
    private TeachersPresenter presenter;
    
    public TeachersView(String title){
        initialize(title);
    }

    private void initialize(String title) {
    }

    public void setPresenter(final TeachersPresenter presenter) {
        this.presenter = presenter;
    }
}
