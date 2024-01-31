package com.movieapp.MovieApp.config;

import com.movieapp.MovieApp.model.Payment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;

import java.util.EnumSet;


@Configuration
@EnableStateMachine
public class StateMachineConfiguration extends StateMachineConfigurerAdapter<Payment.PaymentState, Payment.PaymentEvent> {
    @Override
    public void configure(StateMachineConfigurationConfigurer<Payment.PaymentState, Payment.PaymentEvent> config)
            throws Exception {
        config.withConfiguration()
                .autoStartup(true)
                .listener(listener());
    }

    @Override
    public void configure(StateMachineStateConfigurer<Payment.PaymentState, Payment.PaymentEvent> states)
        throws  Exception{
        states
                .withStates()
                .initial(Payment.PaymentState.NEW)
                .states(EnumSet.allOf(Payment.PaymentState.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<Payment.PaymentState, Payment.PaymentEvent> transitions)
        throws Exception{
        transitions
                .withExternal()
                .source(Payment.PaymentState.NEW).target(Payment.PaymentState.PRE_AUTH).event(Payment.PaymentEvent.PRE_AUTHORIZE)
                .and()
                .withExternal()
                .source(Payment.PaymentState.PRE_AUTH).target(Payment.PaymentState.AUTH).event(Payment.PaymentEvent.AUTHORIZE);
    }

    @Bean
    public StateMachineListener<Payment.PaymentState, Payment.PaymentEvent> listener(){
        return new StateMachineListener<Payment.PaymentState, Payment.PaymentEvent>() {
            @Override
            public void stateChanged(State<Payment.PaymentState, Payment.PaymentEvent> from, State<Payment.PaymentState, Payment.PaymentEvent> to) {
                System.out.println(
                        "State changed from " + from.getId() + " to the following state " + to.getId()
                );
            }

            @Override
            public void stateEntered(State<Payment.PaymentState, Payment.PaymentEvent> state) {

            }

            @Override
            public void stateExited(State<Payment.PaymentState, Payment.PaymentEvent> state) {

            }

            @Override
            public void eventNotAccepted(Message<Payment.PaymentEvent> message) {

            }

            @Override
            public void transition(Transition<Payment.PaymentState, Payment.PaymentEvent> transition) {

            }

            @Override
            public void transitionStarted(Transition<Payment.PaymentState, Payment.PaymentEvent> transition) {

            }

            @Override
            public void transitionEnded(Transition<Payment.PaymentState, Payment.PaymentEvent> transition) {

            }

            @Override
            public void stateMachineStarted(StateMachine<Payment.PaymentState, Payment.PaymentEvent> stateMachine) {

            }

            @Override
            public void stateMachineStopped(StateMachine<Payment.PaymentState, Payment.PaymentEvent> stateMachine) {

            }

            @Override
            public void stateMachineError(StateMachine<Payment.PaymentState, Payment.PaymentEvent> stateMachine, Exception e) {

            }

            @Override
            public void extendedStateChanged(Object o, Object o1) {

            }

            @Override
            public void stateContext(StateContext<Payment.PaymentState, Payment.PaymentEvent> stateContext) {

            }
        };
    }



}
