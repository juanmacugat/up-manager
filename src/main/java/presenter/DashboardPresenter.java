package presenter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.DashboardModel;
import view.DashboardView;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DashboardPresenter {

    private DashboardView view;
    private DashboardModel model;
}
