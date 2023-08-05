package com.company.behavioral.state;

public class MobileAlertStateContext {

    private MobileAlertState currentState;

    public MobileAlertStateContext(){
        currentState = new Sound();
    }

    public void setState(MobileAlertState state){
        currentState = state;
    }

    public void alert(){
        currentState.alert(this);
    }
}
