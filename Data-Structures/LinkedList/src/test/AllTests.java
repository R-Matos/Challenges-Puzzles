package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses
({ 
	LLAddFirst.class, 
	LLAddLast.class,
	LLPeakFirst.class,
	LLPeakLast.class,
	LLRemove.class,
	LLRemoveFirst.class,
	LLRemove.class	
})

public class AllTests {

}
