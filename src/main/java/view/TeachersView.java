package view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import presenter.TeachersPresenter;

@Getter
@Setter
@AllArgsConstructor
public class TeachersView {
    
    private TeachersPresenter presenter;
    
    public TeachersView(String title){
        initialize(title);
    }

    private void initialize(String title) {
    }
}
