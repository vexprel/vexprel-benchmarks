package org.vexprel.benchmarks.benchmark01;

import java.lang.reflect.Method;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;

public class IntrospectionMethodBenchmark extends BaseBenchmark {

    private User user;
    private Method method;


    @Setup
    public void setup() throws Exception {
        this.user = buildUser();
        this.method = User.class.getMethod("getName");
    }


    @Benchmark
    public String benchmark() throws Exception {
        return (String) this.method.invoke(this.user);
    }

}
