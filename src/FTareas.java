
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FTareas extends javax.swing.JFrame {

    ImageIcon icono = new ImageIcon(getClass().getResource("/img/pacientes.png"));

    //----------------------------------------------------------------------------------//
    
    String url = "http://gts220716711.webcindario.com/mysql.php";
    ConexionHR cnx = new ConexionHR(url);

    String tareas = "SELECT idtareas, nombret, calificacion FROM tareas ORDER BY idtareas ";

    // Para promedios mensuales de calificación FINAL por tarea
    String nivelesTareas
            = "SELECT MONTH(fecha_entrega) AS mes, AVG(calificacionf) AS promedio "
            + "FROM asignadas ";

    String grupoTareas
            = "GROUP BY tareas_idtareas, MONTH(fecha_entrega)";

    //-------------------------------------------------------------------------------------//
    public FTareas() {
        initComponents();

        setLocationRelativeTo(this);
        this.setIconImage(icono.getImage());

        cnx.entablar(tareas, Ttareas);
        //cnx.seleccionar(tareas, CBTarea);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PTitulo = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        BOrdenarTa = new javax.swing.JButton();
        BNuevo = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        BAgregar = new javax.swing.JButton();
        BActualizar = new javax.swing.JButton();
        BBorrar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        BPdf = new javax.swing.JButton();
        BGrafica = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jLabel6 = new javax.swing.JLabel();
        TFiltroMa = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jLabel13 = new javax.swing.JLabel();
        TFiltroCalMin = new javax.swing.JTextField();
        BBuscarAlumnos = new javax.swing.JButton();
        PFormulario = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TNombret = new javax.swing.JTextField();
        Tit = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TMateria = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        TInd = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        TCali = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        DCfechaA = new com.toedter.calendar.JDateChooser();
        DCfechaL = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        Ttareas = new javax.swing.JTable();
        PFondo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Universidad - Modulo de Tareas");
        setBackground(new java.awt.Color(0, 0, 0));

        PTitulo.setBackground(new java.awt.Color(0, 0, 51));
        PTitulo.setLayout(null);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 153, 255));
        jLabel11.setText("Tareas Regristro");
        PTitulo.add(jLabel11);
        jLabel11.setBounds(150, 8, 230, 40);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Modulo de Tareas");
        PTitulo.add(jLabel9);
        jLabel9.setBounds(150, 50, 200, 20);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pacientes.png"))); // NOI18N
        PTitulo.add(jLabel8);
        jLabel8.setBounds(19, 17, 95, 60);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo.png"))); // NOI18N
        PTitulo.add(jLabel10);
        jLabel10.setBounds(0, 0, 1190, 90);

        jToolBar1.setRollover(true);

        BOrdenarTa.setText("ORDENAR");
        BOrdenarTa.setFocusable(false);
        BOrdenarTa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BOrdenarTa.setMaximumSize(new java.awt.Dimension(100, 70));
        BOrdenarTa.setMinimumSize(new java.awt.Dimension(100, 70));
        BOrdenarTa.setPreferredSize(new java.awt.Dimension(100, 70));
        BOrdenarTa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BOrdenarTa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BOrdenarTaActionPerformed(evt);
            }
        });
        jToolBar1.add(BOrdenarTa);

        BNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/new.png"))); // NOI18N
        BNuevo.setText("NUEVO");
        BNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BNuevo.setMaximumSize(new java.awt.Dimension(100, 70));
        BNuevo.setMinimumSize(new java.awt.Dimension(100, 70));
        BNuevo.setPreferredSize(new java.awt.Dimension(100, 70));
        BNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BNuevoActionPerformed(evt);
            }
        });
        jToolBar1.add(BNuevo);
        jToolBar1.add(jSeparator2);

        BAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        BAgregar.setText("AGREGAR");
        BAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BAgregar.setMaximumSize(new java.awt.Dimension(100, 70));
        BAgregar.setMinimumSize(new java.awt.Dimension(100, 70));
        BAgregar.setPreferredSize(new java.awt.Dimension(100, 70));
        BAgregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAgregarActionPerformed(evt);
            }
        });
        jToolBar1.add(BAgregar);

        BActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        BActualizar.setText("ACTUALIZAR");
        BActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BActualizar.setMaximumSize(new java.awt.Dimension(100, 70));
        BActualizar.setMinimumSize(new java.awt.Dimension(100, 70));
        BActualizar.setPreferredSize(new java.awt.Dimension(100, 70));
        BActualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BActualizarActionPerformed(evt);
            }
        });
        jToolBar1.add(BActualizar);

        BBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        BBorrar.setText("BORRAR");
        BBorrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BBorrar.setMaximumSize(new java.awt.Dimension(100, 70));
        BBorrar.setMinimumSize(new java.awt.Dimension(100, 70));
        BBorrar.setPreferredSize(new java.awt.Dimension(100, 70));
        BBorrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BBorrarActionPerformed(evt);
            }
        });
        jToolBar1.add(BBorrar);
        jToolBar1.add(jSeparator1);

        BPdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pdf.png"))); // NOI18N
        BPdf.setText("PDF");
        BPdf.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BPdf.setMaximumSize(new java.awt.Dimension(100, 70));
        BPdf.setMinimumSize(new java.awt.Dimension(100, 70));
        BPdf.setPreferredSize(new java.awt.Dimension(100, 70));
        BPdf.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BPdfActionPerformed(evt);
            }
        });
        jToolBar1.add(BPdf);

        BGrafica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Graph.png"))); // NOI18N
        BGrafica.setText("GRAFICA");
        BGrafica.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BGrafica.setMaximumSize(new java.awt.Dimension(100, 70));
        BGrafica.setMinimumSize(new java.awt.Dimension(100, 70));
        BGrafica.setPreferredSize(new java.awt.Dimension(100, 70));
        BGrafica.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BGrafica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BGraficaActionPerformed(evt);
            }
        });
        jToolBar1.add(BGrafica);
        jToolBar1.add(jSeparator3);

        jLabel6.setText("MAT:");
        jToolBar1.add(jLabel6);

        TFiltroMa.setMaximumSize(new java.awt.Dimension(150, 50));
        TFiltroMa.setMinimumSize(new java.awt.Dimension(150, 50));
        TFiltroMa.setPreferredSize(new java.awt.Dimension(150, 50));
        jToolBar1.add(TFiltroMa);
        jToolBar1.add(jSeparator4);

        jLabel13.setText("CALMIN:");
        jToolBar1.add(jLabel13);

        TFiltroCalMin.setMaximumSize(new java.awt.Dimension(150, 50));
        TFiltroCalMin.setMinimumSize(new java.awt.Dimension(150, 50));
        TFiltroCalMin.setPreferredSize(new java.awt.Dimension(150, 50));
        jToolBar1.add(TFiltroCalMin);

        BBuscarAlumnos.setText("BUSCAR");
        BBuscarAlumnos.setFocusable(false);
        BBuscarAlumnos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BBuscarAlumnos.setMaximumSize(new java.awt.Dimension(100, 70));
        BBuscarAlumnos.setMinimumSize(new java.awt.Dimension(100, 70));
        BBuscarAlumnos.setPreferredSize(new java.awt.Dimension(100, 70));
        BBuscarAlumnos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BBuscarAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BBuscarAlumnosActionPerformed(evt);
            }
        });
        jToolBar1.add(BBuscarAlumnos);

        PFormulario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Paciente:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(78, 80, 82));
        jLabel1.setText("IDTareas:");

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(78, 80, 82));
        jLabel2.setText("NOMBRE:");

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(78, 80, 82));
        jLabel5.setText("MATERIA:");

        TMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TMateriaActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(78, 80, 82));
        jLabel7.setText("INDICACIONES:");

        TInd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TIndActionPerformed(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(204, 204, 204));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(78, 80, 82));
        jLabel12.setText("CALIFICACION:");

        jLabel3.setText("FECHA ASI");

        jLabel4.setText("FECHA LIM");

        javax.swing.GroupLayout PFormularioLayout = new javax.swing.GroupLayout(PFormulario);
        PFormulario.setLayout(PFormularioLayout);
        PFormularioLayout.setHorizontalGroup(
            PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PFormularioLayout.createSequentialGroup()
                .addGroup(PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PFormularioLayout.createSequentialGroup()
                        .addGroup(PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                        .addGap(25, 25, 25)
                        .addGroup(PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TInd)
                            .addGroup(PFormularioLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(TMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TCali, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(110, 110, 110)
                                .addComponent(DCfechaL, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PFormularioLayout.createSequentialGroup()
                        .addGroup(PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PFormularioLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                .addGroup(PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Tit, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PFormularioLayout.createSequentialGroup()
                                        .addComponent(TNombret, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addGroup(PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(PFormularioLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DCfechaA, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        PFormularioLayout.setVerticalGroup(
            PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PFormularioLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Tit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(TNombret, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(DCfechaA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(TMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(DCfechaL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(TCali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TInd, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
        );

        Ttareas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Ttareas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TtareasMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(Ttareas);

        PFondo.setBackground(new java.awt.Color(255, 255, 204));
        PFondo.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(PFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 1185, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(PTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BPdfActionPerformed
        String idTarea = Tit.getText().trim();   // idtareas de la tarea seleccionada

        if (idTarea.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Selecciona primero una tarea.",
                    "Sin tarea",
                    javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Armamos el SQL: base + WHERE + GROUP BY
        String query = nivelesTareas
                + "WHERE tareas_idtareas = '" + idTarea + "' "
                + grupoTareas;

        System.out.println("CONSULTA PDF TAREAS: " + query);

        // 2 columnas: mes, promedio
        float[] anchos = new float[]{0.5f, 0.5f};

        int ok = cnx.crearPDF(
                "Reporte de Tarea",
                "Promedio mensual de calificación de la tarea " + idTarea,
                query,
                anchos,
                "promedio_mensual_tarea_" + idTarea
        );

        if (ok == 1) {
            cnx.visualizarPDF("promedio_mensual_tarea_" + idTarea);
        } else {
            System.out.println("No se generó el PDF de tareas.");
        }
    }//GEN-LAST:event_BPdfActionPerformed

    private void BNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BNuevoActionPerformed
        Tit.setText("");
        TNombret.setText("");
        TMateria.setText("");
        TCali.setText("");
        TInd.setText("");
        DCfechaA.setDate(null);
        DCfechaL.setDate(null);

    }//GEN-LAST:event_BNuevoActionPerformed

    private void BGraficaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BGraficaActionPerformed
        String idTarea = Tit.getText().trim();   // idtareas

        if (idTarea.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Selecciona primero una tarea.",
                    "Sin tarea",
                    javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        String query = nivelesTareas
                + "WHERE tareas_idtareas = '" + idTarea + "' "
                + grupoTareas;

        System.out.println("CONSULTA GRAFICA TAREAS: " + query);

        ArrayList<String> series = new ArrayList<>();
        ArrayList<ArrayList<String>> datos = cnx.consultar(query);

        // Nombre de la serie = id de la tarea
        series.add(idTarea);

        GraficaXY graf = new GraficaXY(
                "Promedio Mensual de Calificaciones por Tarea",
                "Mes",
                "Promedio",
                series,
                datos
        );

        PFondo.removeAll();
        PFondo.add(graf.chartPanel);
        PFondo.updateUI();
    }//GEN-LAST:event_BGraficaActionPerformed

    private void BAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAgregarActionPerformed
        String id = Tit.getText().trim();
        String nom = TNombret.getText().trim();
        String calif = TCali.getText().trim();
        String ind = TInd.getText().trim();
        String mat = TMateria.getText().trim();
        String fasig = cnx.toSQL(DCfechaA.getDate());
        String fli = cnx.toSQL(DCfechaL.getDate());

        if (id.isEmpty() || nom.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "ID y Nombre son obligatorios.",
                    "Datos incompletos",
                    javax.swing.JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // --- llamar a la API de tareas ---
        int ok = insertarTareaAPI(id, nom, mat, calif, fasig, fli, ind);
        // si pones el método dentro del JFrame en vez de ConexionHR, quita el "cnx."

        if (ok == 1) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Tarea agregada correctamente.",
                    "Éxito",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE
            );

            // Recargar la tabla de tareas
            String consulta = "SELECT idtareas, nombret, calificacion FROM tareas ORDER BY idtareas";
            cnx.entablar(consulta, Ttareas);

        } else {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "No se pudo agregar la tarea. Revisa la consola (RESPUESTA API).",
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE
            );
        }

    }//GEN-LAST:event_BAgregarActionPerformed

    private void BActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BActualizarActionPerformed
        String id = Tit.getText().trim();
        String nom = TNombret.getText().trim();
        String calif = TCali.getText().trim();
        String ind = TInd.getText().trim();
        String mat = TMateria.getText().trim();
        String fasig = cnx.toSQL(DCfechaA.getDate());
        String fli = cnx.toSQL(DCfechaL.getDate());

        String[] valores = new String[]{id, nom, mat, calif, fasig, fli, ind};
        cnx.actualizar("tareas", valores);
        cnx.entablar(tareas, Ttareas);

    }//GEN-LAST:event_BActualizarActionPerformed

    private void BBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBorrarActionPerformed
        String id = Tit.getText().trim();
        if (id.isEmpty()) {
            return;
        }

        int ok = cnx.borrarTareaAPI(id);

        if (ok == 1) {
            cnx.entablar(tareas, Ttareas);   // recargar tabla
        } else {
            System.out.println("No se pudo borrar la tarea " + id);
        }
    }//GEN-LAST:event_BBorrarActionPerformed

    private void TtareasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TtareasMousePressed
        DefaultTableModel datos = (DefaultTableModel) Ttareas.getModel();
        int renSel = Ttareas.getSelectedRow();

        if (renSel > -1) {
            String id = datos.getValueAt(renSel, 0).toString(); // idtareas
            String nom = datos.getValueAt(renSel, 1).toString(); // nombret
            String calif = datos.getValueAt(renSel, 2).toString(); // calificacion (si la tienes en la tabla)
            String mat = cnx.obtenerDato("SELECT materia FROM tareas WHERE idtareas = '" + id + "' ");
            String ind = cnx.obtenerDato("SELECT indicaciones FROM tareas WHERE idtareas = '" + id + "' ");
            String fasig = cnx.obtenerDato("SELECT fecha_asignada FROM tareas WHERE idtareas = '" + id + "' ");
            String fli = cnx.obtenerDato("SELECT fecha_limite FROM tareas WHERE idtareas = '" + id + "' ");

            Tit.setText(id);
            TNombret.setText(nom);
            TCali.setText(calif);
            TMateria.setText(mat);
            TInd.setText(ind);

            if (fasig != null && !fasig.trim().isEmpty()) {
                DCfechaA.setDate(cnx.toDate(fasig));
            } else {
                DCfechaA.setDate(null);
            }

            if (fli != null && !fli.trim().isEmpty()) {
                DCfechaL.setDate(cnx.toDate(fli));
            } else {
                DCfechaL.setDate(null);
            }
        }

    }//GEN-LAST:event_TtareasMousePressed

    private void TIndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TIndActionPerformed

    }//GEN-LAST:event_TIndActionPerformed

    private void TMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TMateriaActionPerformed

    }//GEN-LAST:event_TMateriaActionPerformed

    private void BBuscarAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBuscarAlumnosActionPerformed
        String materia = TFiltroMa.getText().trim();
        String calmin = TFiltroCalMin.getText().trim();

        String sql = "SELECT idtareas, nombret, materia, calificacion, fecha_asignada "
                + "FROM tareas WHERE 1 = 1 ";

        if (!materia.isEmpty()) {
            sql += " AND materia LIKE '%" + materia + "%' ";
        }

        if (!calmin.isEmpty()) {
            try {
                double calMin = Double.parseDouble(calmin);
                sql += " AND calificacion >= " + calMin;
            } catch (NumberFormatException e) {
                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Calificación mínima inválida.",
                        "Error en filtro",
                        javax.swing.JOptionPane.ERROR_MESSAGE
                );
            }
        }

        sql += " ORDER BY materia, fecha_asignada ";

        cnx.entablar(sql, Ttareas);
    }//GEN-LAST:event_BBuscarAlumnosActionPerformed

    private void BOrdenarTaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BOrdenarTaActionPerformed
        String sql = "SELECT idtareas, nombret, calificacion "
                + "FROM tareas "
                + "ORDER BY materia, fecha_asignada";  // 2 campos

        cnx.entablar(sql, Ttareas);
    }//GEN-LAST:event_BOrdenarTaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FTareas().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BActualizar;
    private javax.swing.JButton BAgregar;
    private javax.swing.JButton BBorrar;
    private javax.swing.JButton BBuscarAlumnos;
    private javax.swing.JButton BGrafica;
    private javax.swing.JButton BNuevo;
    private javax.swing.JButton BOrdenarTa;
    private javax.swing.JButton BPdf;
    private com.toedter.calendar.JDateChooser DCfechaA;
    private com.toedter.calendar.JDateChooser DCfechaL;
    private javax.swing.JPanel PFondo;
    private javax.swing.JPanel PFormulario;
    private javax.swing.JPanel PTitulo;
    private javax.swing.JTextField TCali;
    private javax.swing.JTextField TFiltroCalMin;
    private javax.swing.JTextField TFiltroMa;
    private javax.swing.JTextField TInd;
    private javax.swing.JTextField TMateria;
    private javax.swing.JTextField TNombret;
    private javax.swing.JTextField Tit;
    private javax.swing.JTable Ttareas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

    public int insertarTareaAPI(
            String id,
            String nombre,
            String materia,
            String calificacion,
            String fechaAsignada,
            String fechaLimite,
            String indicaciones) {

        try {
            StringBuilder postData = new StringBuilder();

            String[][] params = {
                {"key", "secret"},
                {"accion", "insertTarea"},
                {"idtareas", id},
                {"nombret", nombre},
                {"materia", materia},
                {"calificacion", calificacion}, // será FLOAT en PHP
                {"fecha_asignada", fechaAsignada}, // formato yyyy-MM-dd
                {"fecha_limite", fechaLimite}, // formato yyyy-MM-dd
                {"indicaciones", indicaciones}
            };

            for (int i = 0; i < params.length; i++) {
                if (i > 0) {
                    postData.append('&');
                }
                postData.append(java.net.URLEncoder.encode(params[i][0], "UTF-8"));
                postData.append('=');
                postData.append(java.net.URLEncoder.encode(
                        params[i][1] == null ? "" : params[i][1],
                        "UTF-8"
                ));
            }

            byte[] postBytes = postData.toString().getBytes("UTF-8");

            java.net.URL u = new java.net.URL("http://gts220716711.webcindario.com/tareas_api.php");
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection) u.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            conn.getOutputStream().write(postBytes);

            java.io.InputStream is = conn.getInputStream();
            java.util.Scanner s = new java.util.Scanner(is, "UTF-8").useDelimiter("\\A");
            String respuesta = s.hasNext() ? s.next() : "";
            System.out.println("RESPUESTA API TAREAS: " + respuesta);

            // Si el PHP responde "OK" consideramos que se insertó bien
            return respuesta.contains("OK") ? 1 : 0;

        } catch (Exception e) {
            System.out.println("Error API insertTarea: " + e.getMessage());
            return 0;
        }
    }

}
