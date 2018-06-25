package presenter;

import model.ErrorModel;
import view.ErrorView;

public class ErrorPresenter {

    private ErrorView view;
    private ErrorModel model;

    public ErrorPresenter(ErrorView view, ErrorModel errorModel) {

        this.model = errorModel;
        this.view = view;

    }

    public String getMessage() {
        return model.getMessage();
    }
}
