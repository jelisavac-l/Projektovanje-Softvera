package exepts;

import javax.swing.JOptionPane;

/**
 *
 * @author luka
 */
public class ModalException extends Exception{

    public ModalException() {
        JOptionPane.showMessageDialog(null, "Desila se nepoznata greška", "Sistem", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Constructs an instance of <code>ModalException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public ModalException(String msg) {
        super(msg);
        JOptionPane.showMessageDialog(null, msg, "Sistem", JOptionPane.ERROR_MESSAGE);
    }
}
