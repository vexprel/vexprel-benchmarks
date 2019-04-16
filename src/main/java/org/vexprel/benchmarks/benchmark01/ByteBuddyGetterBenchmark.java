package org.vexprel.benchmarks.benchmark01;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;
import org.vexprel.standard.action.ByteCodeGenStandardExpressionActionFactory;
import org.vexprel.standard.action.StandardExpressionAction;
import org.vexprel.standard.action.StandardExpressionActionFactory;
import org.vexprel.standard.step.ObjectPropertyExpressionStep;
import org.vexprel.standard.step.StandardExpressionStep;

public class ByteBuddyGetterBenchmark extends BaseBenchmark {

    private User user;
    private StandardExpressionAction getterAction;


    @Setup
    public void setup() throws Exception {
        this.user = buildUser();
        final StandardExpressionStep step = new ObjectPropertyExpressionStep("name");
        final StandardExpressionActionFactory factory = new ByteCodeGenStandardExpressionActionFactory(true);
        this.getterAction = factory.build(step, User.class);
    }


    @Benchmark
    public String benchmark() throws Exception {
        return (String) this.getterAction.execute(this.user);
    }



}
