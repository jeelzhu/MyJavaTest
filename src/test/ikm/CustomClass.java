package ikm;

public class CustomClass  {
}


interface IKMObserver{}
interface Environment {}
interface IKMEnvironment extends Environment {}
interface IKMProgramEnvironment extends IKMEnvironment {}
class JavaSEEnvironment implements Environment {}
class TestEnvironment implements IKMEnvironment {}
class JavaSETestEnvironment extends TestEnvironment {}
class JavaSE7TestEnvironment implements IKMObserver  {}
class JavaEETestEnvironment implements IKMObserver, IKMProgramEnvironment  {}
