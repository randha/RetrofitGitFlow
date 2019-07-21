package pe.edu.cibertec.retrofitgitflow.di.module;

import dagger.Provides;
import dagger.Module;
import pe.edu.cibertec.retrofitgitflow.domain.main_interactor.IMainInteractor;
import pe.edu.cibertec.retrofitgitflow.domain.main_interactor.MainInteractorImpl;
import pe.edu.cibertec.retrofitgitflow.presentation.main.presenter.MainPresenter;

@Module
public class PresentationModule {

    @Provides
    IMainInteractor provideMainInteractor(){
        return new MainInteractorImpl();
    }
}