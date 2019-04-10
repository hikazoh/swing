(ns core
  (:import [javax.swing JFrame JPanel JButton JLabel JOptionPane]
           [java.awt.event ActionListener]
           [java.awt Container BorderLayout])
  (:gen-class))

(defn -main[& args]
  (let [frame (JFrame. "Sample")
        panel (JPanel.)
        button (JButton. "Push Me!")
        label (JLabel. "Push Button Panel")]
    (.setBounds frame 100 100 400 400)
    (.setDefaultCloseOperation frame JFrame/EXIT_ON_CLOSE)
    (.add panel button)
    (.. frame getContentPane (add panel BorderLayout/CENTER))
    (.addActionListener
     button
     (reify ActionListener
       (actionPerformed [this e]
         (JOptionPane/showMessageDialog frame label))))
    (.setVisible frame true)
    )
)
