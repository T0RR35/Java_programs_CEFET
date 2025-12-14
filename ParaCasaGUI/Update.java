import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.util.Iterator;
import java.util.Scanner;

public class Update {

    public Update(final Container pane, JPanel compsToExperiment, JPanel controls, String nome) {
        if (nome.equals(null)) {
            updateNull(pane, compsToExperiment, controls);
        } else {
            updateNome(pane, compsToExperiment, controls, nome);
        }
    }

    public void updateNull(final Container pane, JPanel compsToExperiment, JPanel controls){

    }

    public void updateNome(final Container pane, JPanel compsToExperiment, JPanel controls, String nome){
        
    }
}
