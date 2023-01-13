package co.com.sofka.app;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static junit.framework.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class DependencyTest
{


  @Mock
  private Dependency dependency;

  @Before
  public void setupMock(){
    MockitoAnnotations.openMocks(this);

  }

  //Implementación de Dummy
  @Test
  public void testDependency(){
      when(dependency.getClassName()).thenReturn("hi there");

      assertEquals("hi there", dependency.getClassName());
  }

  //Prueba de lanzamiento de excepciones
  @Test(expected = IllegalArgumentException.class)
  public void testException(){
      when(dependency.getClassName()).thenThrow(IllegalArgumentException.class);

      dependency.getClassName();
  }

  /*Si el método recibe parámetros,
  debemos especificar el conjunto de valores
  para los que se devolverá el resultado que
  estamos definiendo. Por ejemplo.*/
  @Test
  public void testAddTwo(){
      when(dependency.addTwo(1)).thenReturn(5);

      assertEquals(5,dependency.addTwo(1));
      assertEquals(0, dependency.addTwo(27));
  }

  @Test
  public void testAddTwoAny(){
      when(dependency.addTwo(anyInt())).thenReturn(0);

      assertEquals(0, dependency.addTwo(3));
      assertEquals(0, dependency.addTwo(80));
  }
}

