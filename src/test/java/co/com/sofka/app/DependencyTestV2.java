package co.com.sofka.app;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DependencyTestV2 {
    @Mock
    private SubDependency subDependency;
    private Dependency dependency;

    @Before
    public void setupMock(){
        subDependency = mock(SubDependency.class);
        dependency = new Dependency(subDependency);
    }

    @Test
    public void testSubdependency(){
        when(subDependency.getClassName()).thenReturn("hi there 2");

        assertEquals("hi there 2", dependency.getSubdependencyClassName());
    }
}
