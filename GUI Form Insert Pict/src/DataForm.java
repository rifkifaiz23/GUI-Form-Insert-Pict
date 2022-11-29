import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class DataForm {
    private JTextField textNo;
    private JComboBox comboATM;
    private JComboBox comboBank;
    private JTextField textNama;
    private JButton simpanButton;
    private JTextArea outputLine;
    private JButton browseButton;
    private JPanel rootP;
    private JLabel JPict;
    public String fileName;

    public void insertingDataToFile(String inputtedData) throws IOException {
        //Menyimpan data ke file
        try {
            FileWriter myFile = new FileWriter("fileData.txt", true);
            myFile.write(inputtedData);
            myFile.close();
            System.out.println("Succesfully wrote to the file");
        } catch (IOException ex) {
            System.out.println("An error occured");
            ex.printStackTrace();
        }
    }

    public DataForm() {
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser browseImage = new JFileChooser();

                int showOpenDialogue = browseImage.showOpenDialog(null);

                if (showOpenDialogue == JFileChooser.APPROVE_OPTION) {
                    //Mendapatkan nama file image yang diinputkan user
                    fileName = browseImage.getSelectedFile().getName();

                    File selectedImage = browseImage.getSelectedFile();
                    String selectedImagePath = selectedImage.getAbsolutePath();

                    //Menampilkan image di JLabel
                    ImageIcon ii = new ImageIcon(selectedImagePath);

                    //Resize image fit ke Jlabel
                    Image image = ii.getImage().getScaledInstance(JPict.getWidth(), JPict.getHeight(), Image.SCALE_SMOOTH);

                    JPict.setIcon(new ImageIcon(image));
                }

            }
        });
        simpanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Mengambil data dari inputan user
                String no = textNo.getText();
                String atm = (String) comboATM.getSelectedItem();
                String bank = (String) comboBank.getSelectedItem();
                String nama = textNama.getText();

                Data data = new Data();
                data.setNo(no);
                data.setAtm(atm);
                data.setBank(bank);
                data.setNama(nama);

                //Menampilkan data di textArea
                String hasil = "Saved!" + "\nNo Kartu = " + no + "\nJenis ATM = " + atm + "\nBank = " + bank +
                        "\nNama Pemilik = " + nama + "\nNama File Gambar = " + fileName;

                outputLine.append(hasil);

                //Menampilkan nama file gambar ke textArea
                try {
                    insertingDataToFile(hasil + "\n\n");
                    fileName = null;
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public JPanel getRootP() {
        return rootP;
    }
}
