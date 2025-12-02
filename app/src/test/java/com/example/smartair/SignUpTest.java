package com.example.smartair;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.example.smartair.presenter.SigninPresenter;
import com.example.smartair.view.SigninFragmentView;

import org.junit.Before;
import org.junit.Test;

public class SignUpTest {
    private SigninFragmentView view;
    private SigninPresenter presenterSign;

    @Before
    public void start(){
        view = mock(SigninFragmentView.class);
        presenterSign = new SigninPresenter(view);
    }


    @Test
    public void invalidSignUpOneOtherEmpty(){
        presenterSign.onSignUpClick();
        verify(view).makeToast("Please fill all the fields");
    }
}



