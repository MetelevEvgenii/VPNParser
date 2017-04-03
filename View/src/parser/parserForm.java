package parser;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Evgenii on 29.03.2017.
 */
public class parserForm {
    private JPanel view;
    private JPanel buttonView;
    private JButton refreshButton;
    private JPanel resultsView;
    private JList listResults;
    Parser parser;
    private static final int PISITIONX = 500;
    private static final int PISITIONY = 200;
    private static final int WEIDTHTMAINWINDOW = 180;
    private static final int HEIGHTMAINWINDOW = 500;
    public static void main(final String[] args) {
        parserForm parserWindow = new parserForm();
    }
    public parserForm()
    {
        view = new JPanel();
        buttonView = new JPanel();
        refreshButton = new JButton();
        resultsView = new JPanel();
        DefaultListModel listModel = new DefaultListModel();
        listResults = new JList(listModel);
        view.setLayout(new BorderLayout(0, 0));
        view.setPreferredSize(new Dimension(HEIGHTMAINWINDOW, WEIDTHTMAINWINDOW));
        view.add(buttonView, BorderLayout.NORTH);
        view.add(resultsView);
        buttonView.add(refreshButton);
        resultsView.add(listResults);
        refreshButton.setText("Refresh");

        for (int i=0;i<5;i++){

        }



        JFrame frame = new JFrame("VPN");

        refreshButton.addActionListener(e -> {
            backBind();
            for (int i=0; i<5;i++)
            {
                listModel.addElement(parser.getLogin_i(i)+"    Денег: "+parser.money.get(i)+
                        "      Трафика: "+parser.traffic.get(i)+"   Есть обещанный?: "+parser.isEnableFuturePay.get(i));
            }
            frame.pack();

        });

        frame.setLocation(PISITIONX, PISITIONY);
        frame.setContentPane(view);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
    private void bind() {//отдаёт


    }

    private void backBind() {//берёт
        parser = new Parser();
     //   parser.setSetting();
        parser.setSettingHTML();
        parser.clickOnStat();
        for (int i=0; i<5;i++)
        {
            parser.writeLogin(parser.getLogin_i(i));
            parser.writePassword(parser.getPassword_i(i));
            parser.clickLogin();
            parser.viewMoney();
            parser.clickOnReport();
            parser.clickOnObshee();
            parser.clickOnfuturePay();
            parser.clickOnExit();
        }
        parser.closeDriver();
    }
}
