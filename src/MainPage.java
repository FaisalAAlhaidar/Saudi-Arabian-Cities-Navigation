import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCenter;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainPage extends JFrame implements ActionListener {
    public static JXMapViewer jXMapViewer;
    public static final Set<MyWaypoint> waypoints = new HashSet<>();
    public static WaypointRender citiesPainter = new WaypointRender();

    public MainPage() {
        initComponents();
    }
    public static void deployPath(int[] cities) {
        for (MyWaypoint d : waypoints) {
            jXMapViewer.remove(d.getButton());
        }
        List<MyWaypoint> waypointsNew = new ArrayList<>();
        for (int i = 0; i < cities.length; i++) {
            String name = Main.DICTIONARY.rev.get(cities[i]);
            waypointsNew.add(new MyWaypoint(name,
                    new GeoPosition(Main.DICTIONARY.CityCoordinates.get(name).getX(), Main.DICTIONARY.CityCoordinates.get(name).getY())));
        }
        waypoints.clear();
        waypoints.addAll(waypointsNew);
        initWaypoint();
    }

    public static void initWaypoint() {
        citiesPainter = new WaypointRender();
        citiesPainter.setWaypoints(waypoints);
        jXMapViewer.setOverlayPainter(citiesPainter);
        for (MyWaypoint d : waypoints) {
            jXMapViewer.add(d.getButton());
        }
        jXMapViewer.repaint();
    }

    private static void clearWaypoints() {
        for (MyWaypoint d : waypoints) {
            jXMapViewer.remove(d.getButton());
        }
        waypoints.clear();
        initWaypoint();
    }

    private void initMap() {
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        jXMapViewer.setTileFactory(tileFactory);
        GeoPosition geo = new GeoPosition(24.7460632850828, 45.27315581580445);
        jXMapViewer.setAddressLocation(geo);
        jXMapViewer.setZoom(13);
        MouseInputListener mm = new PanMouseInputListener(jXMapViewer);
        jXMapViewer.addMouseListener(mm);
        jXMapViewer.addMouseMotionListener(mm);
        jXMapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCenter(jXMapViewer));
        jXMapViewer.setOverlayPainter(citiesPainter);
    }

    public static void setCurrent(String currentPath, String currentDistance) {
        if (currentPath == null || currentDistance == null) {
            currentDistanceResultLabel.setText("");
            return;
        }
        currentPathResultLabel.setText("<html>" + "<div align=right>" + currentPath.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</div>" + "</html>");
        currentDistanceResultLabel.setText(currentDistance);
    }

    public static void setSliderValue() {
        JSlider source = jSlider1;
        Search.sleep = (5 - source.getValue()) * 100;
    }

    private void initComponents() {
        jSlider1 = new JSlider(JSlider.HORIZONTAL, 0, 5, 0);
        jSlider1.setMajorTickSpacing(1);
        jSlider1.setPaintTicks(true);
        jSlider1.setPaintLabels(true);

        jSlider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                setSliderValue();
            }
        });
        setSliderValue();
        jXMapViewer = new JXMapViewer();
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jLabel12 = new JLabel();
        jComboBox5 = new JComboBox<>();
        searchButton1 = new JButton();
        jLabel15 = new JLabel();
        jPanel5 = new JPanel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jComboBox2 = new JComboBox<>();
        jLabel6 = new JLabel();
        jComboBox3 = new JComboBox<>();
        jComboBox4 = new JComboBox<>();
        jLabel7 = new JLabel();
        jComboBox1 = new JComboBox<>();
        jLabel2 = new JLabel();
        jPanel4 = new JPanel();
        currentDistanceResultLabel = new JLabel();
        currentPathLabel = new JLabel();
        jScrollPane1 = new JScrollPane();
        currentPathResultLabel = new JLabel();
        currentDistanceLabel = new JLabel();
        iterationsResultLabel = new JLabel();
        initMap();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jXMapViewer, 985, 985, 985)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jXMapViewer, 837, 837, 837)
        );


        jPanel2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        jLabel12.setFont(new Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel12.setText("اختر الخوارزمية:");

        jComboBox5.setModel(new DefaultComboBoxModel<>(new String[]{"BFS", "UCS", "IDS", "GS", "A*"}));
        jComboBox5.addActionListener(this);

        searchButton1.setText("ابحث");
        searchButton1.addActionListener(this);

        jLabel15.setFont(new Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel15.setText("سرعة تنفيذ الخورازمية:");

        jPanel5.setPreferredSize(new Dimension(160, 113));


        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 194, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel3.setFont(new Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel3.setText(" المدينة:");

        jLabel4.setFont(new Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel4.setText(" المنطقة:");

        jLabel5.setFont(new Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel5.setText(" المدينة:");

        jComboBox2.addActionListener(this);

        jLabel6.setFont(new Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel6.setText("نقطة الانطلاق:");

        jComboBox3.setModel(new DefaultComboBoxModel<>(new String[]{"الرياض", "مكة المكرمة", "المدينة المنورة", "القصيم", "الشرقية", "عسير", "تبوك", "حائل", "الحدود الشمالية", "جازان", "نجران", "الباحة", "الجوف"}));
        jComboBox3.addActionListener(this);

        jComboBox4.addActionListener(this);

        jLabel7.setFont(new Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel7.setText("الوجهة:");

        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[]{"الرياض", "مكة المكرمة", "المدينة المنورة", "القصيم", "الشرقية", "عسير", "تبوك", "حائل", "الحدود الشمالية", "جازان", "نجران", "الباحة", "الجوف"}));
        jComboBox1.addActionListener(this);

        jLabel2.setFont(new Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel2.setText(" المنطقة:");

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jSlider1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                .addGap(49, 49, 49)
                                                .addComponent(jLabel15)
                                                .addGap(42, 42, 42)
                                                .addComponent(jComboBox5, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 50, Short.MAX_VALUE)
                                                .addComponent(jLabel12)
                                                .addContainerGap())
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(164, 164, 164)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jComboBox4, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel5)
                                                                .addGap(81, 81, 81)
                                                                .addComponent(jComboBox3, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel4))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(2, 2, 2)
                                                                .addComponent(jLabel3)
                                                                .addGap(81, 81, 81)
                                                                .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel2)))
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                                .addComponent(searchButton1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(48, 48, 48)))
                                                .addGap(280, 280, 280))
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel7)
                                                        .addComponent(jLabel6))
                                                .addGap(6, 6, 6))))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel12)
                                        .addComponent(jComboBox5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3)
                                        .addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(15, 15, 15)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jComboBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5)
                                        .addComponent(jComboBox4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel15)
                                        .addComponent(jSlider1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addComponent(searchButton1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                                .addContainerGap())
        );
        setJComboBox(jComboBox1);
        setJComboBox(jComboBox3);
        jPanel4.setSize(new Dimension(987, 126));

        currentDistanceResultLabel.setFont(new Font("Lucida Grande", 0, 18));
        currentDistanceResultLabel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        currentPathLabel.setFont(new Font("Lucida Grande", 0, 18)); // NOI18N
        currentPathLabel.setText("مسار الرحلة الحالية: ");

        jScrollPane1.getViewport().setBackground(new Color(238, 238, 238));
        jScrollPane1.setBorder(null);
        jScrollPane1.setSize(new Dimension(559, 67));

        currentPathResultLabel.setBackground(Color.lightGray);
        currentPathResultLabel.setFont(new Font("Lucida Grande", 0, 18));
        currentPathResultLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        jScrollPane1.setViewportView(currentPathResultLabel);
        currentDistanceLabel.setFont(new Font("Lucida Grande", 0, 18)); // NOI18N
        currentDistanceLabel.setText("مسافة الرحلة الحالية (Km):");

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(currentDistanceResultLabel, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(currentDistanceLabel)
                                                .addGap(475, 475, 475)
                                                .addComponent(currentPathLabel)
                                                .addContainerGap(12, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 766, GroupLayout.PREFERRED_SIZE)
                                                .addGap(29, 29, 29))))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(currentPathLabel)
                                                .addComponent(currentDistanceLabel))
                                        .addComponent(currentDistanceResultLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        iterationsResultLabel.setFont(new Font("Lucida Grande", 0, 18)); // NOI18N


        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(112, 112, 112)
                                                                .addComponent(iterationsResultLabel, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(48, 48, 48)))
                                                .addGap(12, 12, 12))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(iterationsResultLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(113, Short.MAX_VALUE))
        );

        pack();
    }

    public void setJComboBox(JComboBox box) {
        if (box.equals(jComboBox1)) {
            jComboBox2.setModel(new DefaultComboBoxModel<String>(Main.DICTIONARY.RegionCity.get(jComboBox1.getSelectedItem().toString()).toArray(new String[0])));
        }
        if (box.equals(jComboBox3)) {
            jComboBox4.setModel(new DefaultComboBoxModel<String>(Main.DICTIONARY.RegionCity.get(jComboBox3.getSelectedItem().toString()).toArray(new String[0])));
        }
    }

    private JLabel currentDistanceLabel;
    private static JLabel currentDistanceResultLabel;
    private JLabel currentPathLabel;
    private static JLabel currentPathResultLabel;
    private JLabel iterationsResultLabel;
    private JComboBox<String> jComboBox1;
    private JComboBox<String> jComboBox2;
    private JComboBox<String> jComboBox3;
    private JComboBox<String> jComboBox4;
    private JComboBox<String> jComboBox5;
    private JLabel jLabel12;
    private JLabel jLabel15;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JScrollPane jScrollPane1;
    private static JSlider jSlider1;
    private JButton searchButton1;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(jComboBox1)) {
            this.setJComboBox(jComboBox1);
        }
        if (e.getSource().equals(jComboBox3)) {
            this.setJComboBox(jComboBox3);
        }
        if (e.getSource().equals(searchButton1)) {
            clearWaypoints();
            citiesPainter.setSolution(null);
            jXMapViewer.repaint();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int source = Main.DICTIONARY.map.get(jComboBox2.getSelectedItem().toString());
                    int destination = Main.DICTIONARY.map.get(jComboBox4.getSelectedItem().toString());
                    System.out.println(jComboBox2.getSelectedItem().toString() + " " + jComboBox4.getSelectedItem().toString());
                    switch (jComboBox5.getSelectedIndex()) {
                        case 0:
                            Search.BFS(source, destination);
                            break;
                        case 1:
                            Search.UCS(source, destination);
                            break;
                        case 2:
                            Search.IDS(source, destination);
                            break;
                        case 3:
                            Search.GreedySearch(source, destination);
                            break;
                        case 4:
                            Search.AStar(source, destination);
                    }
                }
            }).start();
        }
    }
}
