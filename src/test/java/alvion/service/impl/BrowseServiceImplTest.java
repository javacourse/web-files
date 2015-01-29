package alvion.service.impl;

import alvion.common.FileEntry;
import alvion.controller.BrowseController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;

public class BrowseServiceImplTest {
    private BrowseServiceImpl browseService;
    private String path;

    @Before
    public void setUp() throws Exception {
        browseService = new BrowseServiceImpl();
        String appPath = BrowseController.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        StringBuilder testPath = new StringBuilder(appPath.substring(0, appPath.indexOf("target")));
        // removing possible leading slash
        while(testPath.toString().indexOf('/')==0) testPath.deleteCharAt(0);

        System.out.println( testPath );
        path = FileEntry.cleanPath(testPath.toString());

    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown");
    }

    @Test
    public void testGetDirContent() throws Exception {

        browseService.readDirectory(path);

        String[] expectedResult = new String[] {
                "..",
                ".git",
                ".idea",
                "src",
                "target",
                ".gitignore",
                "pom.xml",
                "web-files.iml"
        };

        ArrayList<String> buffer = new ArrayList<>();

        for (FileEntry file : browseService.getDirContent(path.hashCode())) {
            buffer.add(file.getName());
        }


        String[] filesRead = buffer.toArray(new String[0]);

        assertArrayEquals(expectedResult, filesRead);
    }
}