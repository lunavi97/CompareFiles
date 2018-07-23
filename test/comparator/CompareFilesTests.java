package comparator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CompareFilesTests {

  final String folder = "Folder";
  CompareFiles cf;

  @Before
  public void setUp() {
    cf = new CompareFiles();
  }

  @Test
  public void test() throws IOException {
    new File(folder).mkdir();

    String path1 = folder + File.separator + "file1.txt";
    String path2 = folder + File.separator + "file2.txt";
    String path3 = folder + File.separator + "file3.txt";
    String path4 = folder + File.separator + "file4.txt";
    String path5 = folder + File.separator + "file5.txt";

    crearArchivoTest1(path1);
    crearArchivoTest2(path2);
    crearArchivoTest3(path3);
    crearArchivoTest1(path4);
    crearArchivoTest2(path5);

    // Tienen el mismo contenido
    Assert.assertTrue("Los archivos " + path1 + " y " + path4 + 
        " tienen distinto contenido",
        cf.haveSameContent(new File(path1), new File(path4)));
    Assert.assertTrue("Los archivos " + path2 + " y " + path5 + 
        " tienen distinto contenido",
        cf.haveSameContent(new File(path2), new File(path5)));
    Assert.assertTrue("Los archivos " + path4 + " y " + path1 + 
        " tienen distinto contenido",
        cf.haveSameContent(new File(path4), new File(path1)));
    Assert.assertTrue("Los archivos " + path5 + " y " + path2 + 
        " tienen distinto contenido",
        cf.haveSameContent(new File(path5), new File(path2)));

    // Son los mismos archivos, por lo que tienen el mismo contenido
    Assert.assertTrue("Los archivos " + path1 + " y " + path1 + 
        " tienen distinto contenido",
        cf.haveSameContent(new File(path1), new File(path1)));
    Assert.assertTrue("Los archivos " + path2 + " y " + path2 + 
        " tienen distinto contenido",
        cf.haveSameContent(new File(path2), new File(path2)));
    Assert.assertTrue("Los archivos " + path3 + " y " + path3 + 
        " tienen distinto contenido",
        cf.haveSameContent(new File(path3), new File(path3)));
    Assert.assertTrue("Los archivos " + path4 + " y " + path4 + 
        " tienen distinto contenido",
        cf.haveSameContent(new File(path4), new File(path4)));
    Assert.assertTrue("Los archivos " + path5 + " y " + path5 + 
        " tienen distinto contenido",
        cf.haveSameContent(new File(path5), new File(path5)));

    // Tienen distinto contenido
    Assert.assertFalse("Los archivos " + path1 + " y " + path2 + 
        " tienen el mismo contenido",
        cf.haveSameContent(new File(path1), new File(path2)));
    Assert.assertFalse("Los archivos " + path1 + " y " + path3 + 
        " tienen el mismo contenido",
        cf.haveSameContent(new File(path1), new File(path3)));
    Assert.assertFalse("Los archivos " + path1 + " y " + path5 + 
        " tienen el mismo contenido",
        cf.haveSameContent(new File(path1), new File(path5)));
    Assert.assertFalse("Los archivos " + path2 + " y " + path1 + 
        " tienen el mismo contenido",
        cf.haveSameContent(new File(path2), new File(path1)));
    Assert.assertFalse("Los archivos " + path2 + " y " + path3 + 
        " tienen el mismo contenido",
        cf.haveSameContent(new File(path2), new File(path3)));
    Assert.assertFalse("Los archivos " + path2 + " y " + path4 + 
        " tienen el mismo contenido",
        cf.haveSameContent(new File(path2), new File(path4)));
    Assert.assertFalse("Los archivos " + path3 + " y " + path1 + 
        " tienen el mismo contenido",
        cf.haveSameContent(new File(path3), new File(path1)));
    Assert.assertFalse("Los archivos " + path3 + " y " + path2 + 
        " tienen el mismo contenido",
        cf.haveSameContent(new File(path3), new File(path2)));
    Assert.assertFalse("Los archivos " + path3 + " y " + path4 + 
        " tienen el mismo contenido",
        cf.haveSameContent(new File(path3), new File(path4)));
    Assert.assertFalse("Los archivos " + path3 + " y " + path5 + 
        " tienen el mismo contenido",
        cf.haveSameContent(new File(path3), new File(path5)));
    Assert.assertFalse("Los archivos " + path4 + " y " + path2 + 
        " tienen el mismo contenido",
        cf.haveSameContent(new File(path4), new File(path2)));
    Assert.assertFalse("Los archivos " + path4 + " y " + path3 + 
        " tienen el mismo contenido",
        cf.haveSameContent(new File(path4), new File(path3)));
    Assert.assertFalse("Los archivos " + path4 + " y " + path5 + 
        " tienen el mismo contenido",
        cf.haveSameContent(new File(path4), new File(path5)));
    Assert.assertFalse("Los archivos " + path5 + " y " + path1 + 
        " tienen el mismo contenido",
        cf.haveSameContent(new File(path5), new File(path1)));
    Assert.assertFalse("Los archivos " + path5 + " y " + path3 + 
        " tienen el mismo contenido",
        cf.haveSameContent(new File(path5), new File(path3)));
    Assert.assertFalse("Los archivos " + path5 + " y " + path4 + 
        " tienen el mismo contenido",
        cf.haveSameContent(new File(path5), new File(path4)));
  }

  private void crearArchivoTest1(String path) throws IOException {
    File file = new File(path);
    PrintWriter pw = new PrintWriter(file);
    pw.println("2 3 5 a f pW");
    pw.println("-> -> line");
    pw.println("file <- <-");
    pw.close();
  }

  private void crearArchivoTest2(String path) throws FileNotFoundException {
    File file = new File(path);
    PrintWriter pw = new PrintWriter(file);
    pw.println("$ no val");
    pw.println("lin as foss");
    pw.println("cin << cout");
    pw.close();
  }

  private void crearArchivoTest3(String path) throws FileNotFoundException {
    File file = new File(path);
    PrintWriter pw = new PrintWriter(file);
    pw.println("$ no val");
    pw.println("lin as foss");
    pw.close();
  }

}
