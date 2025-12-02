package com.example.smartair;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.example.smartair.presenter.SigninPresenter;
import com.example.smartair.view.SigninFragmentView;
import org.junit.Test;
import org.junit.Before;


public class SignInPresentTest {
    private SigninFragmentView view;
    private SigninPresenter presenterSign;

    @Before
    public void start(){
        view = mock(SigninFragmentView.class);
        presenterSign = new SigninPresenter(view);
    }


    @Test
    public void emptySignIn(){
        presenterSign.onSignInClick("", "");
        verify(view).showError("Please fill the fields");
    }

    @Test
    public void invalidSignUpOneEmpty(){
        presenterSign.onSignInClick("youngSheldon@gmail.com", "");
        verify(view).showError("Please fill all the fields");
    }

    @Test
    public void invalidSignUpOneOtherEmpty(){
        presenterSign.onSignInClick("", "bazinga");
        verify(view).makeToast("Please fill all the fields");
    }
}
