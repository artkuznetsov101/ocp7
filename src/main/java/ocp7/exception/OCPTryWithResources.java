package ocp7.exception;

class TestAutoClose implements AutoCloseable {
    public TestAutoClose() throws Exception {
        System.out.println("constructor");
    }

    public void method() throws Exception {
        System.out.println("method");
        throw new Exception("method exception");
    }

    public void close() throws Exception {
        System.out.println("close");
        throw new Exception("close exception");
    }
}

public class OCPTryWithResources {
    public static void main(String[] args) throws Exception {
        try (TestAutoClose raftNull = null; TestAutoClose raft = new TestAutoClose()) {
            raft.method();
        } catch (Exception e) {
            System.out.println("Exception caught:" + e);
            Throwable[] exs = e.getSuppressed();
            if (exs.length > 0)
                System.out.println(exs[0]);
        }
    }
}