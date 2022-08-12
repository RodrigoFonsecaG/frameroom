package br.com.frameroom.view;

/**
 *
 * @author Rodrigo
 */
public class LoginOpen {
 
    public static void main(String[] args) {
        Carregamento screen = new Carregamento();
        Login sign = new Login();
        

        
        screen.setVisible(true);
        try {
            for (int row = 0; row <=100; row++) {
                Thread.sleep(20);
                screen.loadingnumber.setText(Integer.toString(row)+"%");
                screen.loadingprogress.setValue(row);
                if (row == 100) {
                    
                    screen.setVisible(false);
                    sign.setVisible(true);
                }
            }
        } catch (Exception e) {
        }
    }
}
