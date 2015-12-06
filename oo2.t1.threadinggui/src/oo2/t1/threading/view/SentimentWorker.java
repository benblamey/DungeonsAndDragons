/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package oo2.t1.threading.view;

import javax.swing.SwingWorker;
import oo2.t1.threading.model.SentimentCalculator;


/**
 *
 * @author ben-laptop
 */
public class SentimentWorker extends SwingWorker {

   // private SentimentCalculator _calc = new SentimentCalculator();
    
    @Override
    protected Object doInBackground() throws Exception {
        // We're on the worker/background thread here.
        System.out.println("doInBackground() on the "+ 
                Thread.currentThread().getName() + " thread.");
        
        // This is going to take ages...
        //_calc.run(null);
        
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            this.setProgress(i*10);
        }
        return null;
    }

    @Override
    protected void done() {
        super.done();  
        // We're on the UI thread here.
        System.out.println("done() on the "+ 
                Thread.currentThread().getName() + " thread.");

    }

    
    
    

    
    
    
}
