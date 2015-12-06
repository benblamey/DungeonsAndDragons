/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threadinggui.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

/**
 * Critical Reflection: is this class a view, model or controller?
 * Is it any of them?
 * How could we structure the code better, or to better fit MVC?
 */
public class SentimentWorker extends SwingWorker {
    
    // Observable pattern for notification of "done" event.
    private List<Observer> _isDoneChangedHandlers = new ArrayList<>();

    public void addIsDoneChangedObserver(Observer handler) {
        _isDoneChangedHandlers.add(handler);
    }
    
    public void removeIsDoneChangedObserver(Observer handler) {
        _isDoneChangedHandlers.remove(handler);
    }
   
    
    private void fireIsDoneChanged() {
        for (Observer handler : _isDoneChangedHandlers) {
            handler.update();
        }
    }
    
    private boolean _isDone;
    private void setIsDone(boolean isDone) {
        
        boolean oldValue = _isDone;
        _isDone = isDone;
        if (oldValue != _isDone){
            fireIsDoneChanged();
        }
        
    }
    
    @Override
    protected Object doInBackground() throws Exception {
        // We expect to be on the worker thread here.
        System.out.println("doInBackground() called on " + 
                Thread.currentThread().getName() + ".");
        
        for (int i = 0; i < 10; i++) {
            // Simulate a complex calculation.
            Thread.sleep(1000);
            setProgress((i+1)*10);
        }
        
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                
            }
        });
        
        
        return null;
    }

    @Override
    protected void done() {
        super.done();
        // We expect to be on the UI thread here.
        System.out.println("done() called on " + 
                Thread.currentThread().getName() + ".");        
        
        // Notify our observers - we're on the UI thread so this is safe to do.
        fireIsDoneChanged();
    }

    
    
    
    
}
