import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("스윙 연습");
        frame.setSize(1200,900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);
        // 라벨 생성
        JLabel label = new JLabel("버튼을 눌러보세요!");
        label.setBounds(130, 50, 200, 30);
        panel.add(label);

        // 버튼 생성
        JButton button = new JButton("클릭");
        button.setBounds(150, 100, 100, 30);
        panel.add(button);

        // 버튼 클릭 이벤트 추가
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("버튼이 눌렸습니다!");
            }
        });
    }


}
