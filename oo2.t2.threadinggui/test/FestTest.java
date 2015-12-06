import javax.swing.SwingUtilities;
import org.fest.swing.edt.FailOnThreadViolationRepaintManager;
import org.fest.swing.edt.GuiActionRunner;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.fixture.JButtonFixture;
import org.fest.swing.fixture.JFileChooserFixture;
import org.fest.swing.timing.Condition;
import org.fest.swing.timing.Pause;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import threadinggui.view.SentimentGUI;

/**
 * Example of Fest testing for a GUI.
 * @author ben@benblamey.com
 */
public class FestTest {
    private FrameFixture window;
    
    public FestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
         // Enable checking that GUI-interaction is happening on the correct thread.
         FailOnThreadViolationRepaintManager.install();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        SentimentGUI frame = GuiActionRunner.execute(new GuiQuery<SentimentGUI>() {
                protected SentimentGUI executeInEDT() {
                  return new SentimentGUI();  
                }
          });
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
    }
    
    
    @Test
    public void sentimentTest() throws InterruptedException {
        // Click the OK button.
        window.button("OKButton").click();
        
        // Get a fixture for the FileChooser.
        JFileChooserFixture fileChooser = window.fileChooser();
        // Enter a filename.
        fileChooser.fileNameTextBox().setText("C:\\work\\docs\\Dropbox\\WIFI.txt");
        // Click ok.
        fileChooser.approve();
        
        // Process should have started now.
        
        // OK button should be disabled.
        window.button("OKButton").requireDisabled();
        
        // Wait for the process to finish (the OK button should be enabled again).
        Pause.pause(new WaitForButtonEnabledCondition(window.button("OKButton")) );
        
        // Double-check that the button is enabled.
        window.button("OKButton").requireEnabled();
        

        
        window.label("foo").requireText("We're done!");
    }
    
    @After
    public void tearDown() {
        window.cleanUp();
    }

    /**
     * A {@linnk Condition} that waits for a {@link JButton} to become enabled.
     */
    private class WaitForButtonEnabledCondition extends Condition {
        private final JButtonFixture button;

        private WaitForButtonEnabledCondition(JButtonFixture button) {
            // Parent class wants to know a description.
            super("Waits the button to be enabled.");
            this.button = button;
        }

        @Override
        public boolean test() {
            return this.button.component().isEnabled();
        }
    }
}