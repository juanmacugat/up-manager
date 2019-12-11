package grades;

import javax.swing.*;

public class GradesView extends JPanel {
    private GradesPresenter presenter;

    public void setPresenter(final GradesPresenter presenter) {
        this.presenter = presenter;
    }

    public GradesView(){
        initialize();
    }

    private void initialize() {

    }
}
