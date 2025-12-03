
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FAsignadas extends javax.swing.JFrame {

    ImageIcon icono = new ImageIcon(getClass().getResource("/img/pacientes.png"));

    //----------------------------------------------------------------------------------//
    String url = "http://gts220716711.webcindario.com/mysql.php";
    ConexionHR cnx = new ConexionHR(url);

    // Tabla de ASIGNADAS
    String asignadas = "SELECT tareas_idtareas, alumnos_idalumnos, fecha_entrega, calificacionf "
            + "FROM asignadas ORDER BY fecha_entrega";

    String idalum = "SELECT alumnos_idalumnos FROM asignadas ORDER BY alumnos_idalumnos ";

    String idta = "SELECT tareas_idtareas FROM asignadas ORDER BY tareas_idtareas ";

    // Para promedios mensuales por ALUMNO
    String niveles = "SELECT MONTH(fecha_entrega) AS mes, AVG(calificacionf) AS promedio "
            + "FROM asignadas ";
    String grupo = "GROUP BY MONTH(fecha_entrega)";
    //----------------------------------------------------------------------------------//

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FAsignadas.class.getName());

    public FAsignadas() {
        initComponents();
        setLocationRelativeTo(this);
        this.setIconImage(icono.getImage());

        // Cargar la tabla de ASIGNADAS (no alumnos)
        cnx.entablar(asignadas, TAsignadas);
        cnx.seleccionar(idalum, CBaluID);
        cnx.seleccionar(idta, CBtarID);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PTitulo = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        PFormulario = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CBEstado = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TCali = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        TComen = new javax.swing.JTextField();
        DFecha = new com.toedter.calendar.JDateChooser();
        CBtarID = new javax.swing.JComboBox<>();
        CBaluID = new javax.swing.JComboBox<>();
        jToolBar1 = new javax.swing.JToolBar();
        BTOrdenar = new javax.swing.JButton();
        BNuevo = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        BAgregar = new javax.swing.JButton();
        BActualizar = new javax.swing.JButton();
        BBorrar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        BPdf = new javax.swing.JButton();
        BGrafica = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        TFiltroCalm = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TFiltroEstado = new javax.swing.JTextField();
        BBuscarAlumnos = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TAsignadas = new javax.swing.JTable();
        PFondo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PTitulo.setBackground(new java.awt.Color(0, 0, 51));
        PTitulo.setLayout(null);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 153, 255));
        jLabel11.setText("Asignadas");
        PTitulo.add(jLabel11);
        jLabel11.setBounds(150, 8, 190, 40);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Modulo de Alumnos");
        PTitulo.add(jLabel9);
        jLabel9.setBounds(150, 50, 200, 20);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/membership_7548026.png"))); // NOI18N
        PTitulo.add(jLabel8);
        jLabel8.setBounds(19, 17, 85, 60);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Screenshot_1.png"))); // NOI18N
        PTitulo.add(jLabel10);
        jLabel10.setBounds(0, 0, 1130, 90);

        PFormulario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Asignados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(78, 80, 82));
        jLabel1.setText("TAREASID:");

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(78, 80, 82));
        jLabel2.setText("IDALUMNOS:");

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(78, 80, 82));
        jLabel4.setText("ESTADO:");

        CBEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ENTREGADO", "RETARDO", "FALTA" }));

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(78, 80, 82));
        jLabel5.setText("FECHA ENTREGA");

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(78, 80, 82));
        jLabel7.setText("CALIFICACION:");

        jLabel12.setBackground(new java.awt.Color(204, 204, 204));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(78, 80, 82));
        jLabel12.setText("COMENTARIOS");

        CBtarID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        CBaluID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout PFormularioLayout = new javax.swing.GroupLayout(PFormulario);
        PFormulario.setLayout(PFormularioLayout);
        PFormularioLayout.setHorizontalGroup(
            PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PFormularioLayout.createSequentialGroup()
                        .addGroup(PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(PFormularioLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))))
                        .addGap(18, 18, 18)
                        .addGroup(PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PFormularioLayout.createSequentialGroup()
                                .addGroup(PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TCali, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CBaluID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(CBtarID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PFormularioLayout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TComen, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140))))
        );
        PFormularioLayout.setVerticalGroup(
            PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PFormularioLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CBtarID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(CBEstado)
                        .addComponent(CBaluID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PFormularioLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addGap(20, 20, 20)
                        .addGroup(PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(TCali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PFormularioLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)))
                .addGroup(PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TComen, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78))
        );

        jToolBar1.setRollover(true);

        BTOrdenar.setText("ORDENAR");
        BTOrdenar.setFocusable(false);
        BTOrdenar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BTOrdenar.setMaximumSize(new java.awt.Dimension(100, 70));
        BTOrdenar.setMinimumSize(new java.awt.Dimension(100, 70));
        BTOrdenar.setPreferredSize(new java.awt.Dimension(100, 70));
        BTOrdenar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BTOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTOrdenarActionPerformed(evt);
            }
        });
        jToolBar1.add(BTOrdenar);

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

        jLabel3.setText("CALMIN:");
        jToolBar1.add(jLabel3);

        TFiltroCalm.setMaximumSize(new java.awt.Dimension(150, 50));
        TFiltroCalm.setMinimumSize(new java.awt.Dimension(150, 50));
        TFiltroCalm.setPreferredSize(new java.awt.Dimension(150, 50));
        jToolBar1.add(TFiltroCalm);

        jLabel6.setText("ESTADO:");
        jToolBar1.add(jLabel6);

        TFiltroEstado.setMaximumSize(new java.awt.Dimension(150, 50));
        TFiltroEstado.setMinimumSize(new java.awt.Dimension(150, 50));
        TFiltroEstado.setPreferredSize(new java.awt.Dimension(150, 50));
        jToolBar1.add(TFiltroEstado);

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

        TAsignadas.setModel(new javax.swing.table.DefaultTableModel(
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
        TAsignadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TAsignadasMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(TAsignadas);

        PFondo.setBackground(new java.awt.Color(255, 255, 204));
        PFondo.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addComponent(PFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(PTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(PFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BNuevoActionPerformed
        CBtarID.setSelectedIndex(0);          // tareas_idtareas
        CBaluID.setSelectedIndex(0);        // alumnos_idalumnos
        CBEstado.setSelectedIndex(0);
        DFecha.setDate(null);     // JDateChooser -> setDate
        TComen.setText("");       // comentariop
        TCali.setText("");        // calificacionf
    }//GEN-LAST:event_BNuevoActionPerformed

    private void BAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAgregarActionPerformed
        // OJO: ajusta los nombres de tus componentes si cambian
        String tareasId = CBtarID.getSelectedItem().toString().trim();
        String alumnosId = CBaluID.getSelectedItem().toString().trim();
        String comentario = TComen.getText().trim();
        String califFinal = TCali.getText().trim();
        String estado = CBEstado.getSelectedItem().toString();

        // >>> FORMATEAR FECHA SIN COMILLAS, yyyy-MM-dd <<<
        String fechaEnt = "";
        if (DFecha.getDate() != null) {
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
            fechaEnt = sdf.format(DFecha.getDate());  // ejemplo: 2025-12-02
        }

        // Validacion basica
        if (tareasId.isEmpty() || alumnosId.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "ID de tarea y alumno son obligatorios.",
                    "Datos incompletos",
                    javax.swing.JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        int ok = insertarAsignadaAPI( // <- OJO: cnx.
                tareasId,
                alumnosId,
                fechaEnt,
                comentario,
                califFinal,
                estado
        );

        if (ok == 1) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Asignacion agregada correctamente.",
                    "Exito",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE
            );

            // Recargar la tabla de asignadas
            String consulta = "SELECT tareas_idtareas, alumnos_idalumnos, "
                    + "fecha_entrega, comentariop, calificacionf, estado "
                    + "FROM asignadas ORDER BY fecha_entrega DESC";

            cnx.entablar(consulta, TAsignadas);
        } else {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "No se pudo agregar la asignacion. Revisa la consola (RESPUESTA API).",
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_BAgregarActionPerformed

    private void BActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BActualizarActionPerformed
        String tareasId = CBtarID.getSelectedItem().toString();
        String alumnosId = CBaluID.getSelectedItem().toString();
        String comentario = TComen.getText().trim();
        String califFinal = TCali.getText().trim();
        String estado = CBEstado.getSelectedItem().toString();
        String fechaEnt = cnx.toSQL(DFecha.getDate());

        String[] valores = new String[]{
            tareasId,
            alumnosId,
            fechaEnt,
            comentario,
            califFinal,
            estado
        };

        cnx.actualizar("asignadas", valores);
        cnx.entablar(asignadas, TAsignadas);
    }//GEN-LAST:event_BActualizarActionPerformed

    private void BBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBorrarActionPerformed
        String tareasId = CBtarID.getSelectedItem().toString();
        String alumnosId = CBaluID.getSelectedItem().toString();
        String comentario = TComen.getText().trim();
        String califFinal = TCali.getText().trim();
        String estado = CBEstado.getSelectedItem().toString();
        String fechaEnt = cnx.toSQL(DFecha.getDate());

        if (tareasId.isEmpty() || alumnosId.isEmpty()) {
            return;
        }

        String[] valores = new String[]{
            tareasId,
            alumnosId,
            fechaEnt,
            comentario,
            califFinal,
            estado
        };

        cnx.borrar("asignadas", valores);
        cnx.entablar(asignadas, TAsignadas);
    }//GEN-LAST:event_BBorrarActionPerformed

    private void BPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BPdfActionPerformed
        String idAlumno = CBaluID.getSelectedItem().toString();   // alumnos_idalumnos

        if (idAlumno.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Selecciona primero un alumno.",
                    "Sin alumno",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        String query = niveles
                + "WHERE alumnos_idalumnos = '" + idAlumno + "' "
                + grupo;

        System.out.println("CONSULTA PDF ASIGNADAS: " + query);

        float[] anchos = new float[]{0.5f, 0.5f};

        int ok = cnx.crearPDF(
                "Reporte de Asignaciones",
                "Promedio mensual de calificaciones finales del alumno " + idAlumno,
                query,
                anchos,
                "promedio_mensual_asignadas_" + idAlumno
        );

        if (ok == 1) {
            cnx.visualizarPDF("promedio_mensual_asignadas_" + idAlumno);
        } else {
            System.out.println("No se generó el PDF de asignadas.");
        }

    }//GEN-LAST:event_BPdfActionPerformed

    private void BGraficaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BGraficaActionPerformed
        String idAlumno = CBaluID.getSelectedItem().toString();   // alumnos_idalumnos

        if (idAlumno.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Selecciona primero un alumno.",
                    "Sin alumno",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        String query = niveles
                + "WHERE alumnos_idalumnos = '" + idAlumno + "' "
                + grupo;

        System.out.println("CONSULTA GRAFICA ASIGNADAS: " + query);

        ArrayList<String> series = new ArrayList<>();
        ArrayList<ArrayList<String>> datos = cnx.consultar(query);

        series.add(idAlumno);

        GraficaXY graf = new GraficaXY(
                "Promedio Mensual de Calificaciones por Alumno",
                "Mes",
                "Promedio",
                series,
                datos
        );

        PFondo.removeAll();
        PFondo.add(graf.chartPanel);
        PFondo.updateUI();
    }//GEN-LAST:event_BGraficaActionPerformed

    private void TAsignadasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TAsignadasMousePressed
        DefaultTableModel datos = (DefaultTableModel) TAsignadas.getModel();
        int renSel = TAsignadas.getSelectedRow();

        if (renSel > -1) {
            String tareasId = datos.getValueAt(renSel, 0).toString(); // tareas_idtareas
            String alumnosId = datos.getValueAt(renSel, 1).toString(); // alumnos_idalumnos
            String fechaEnt = datos.getValueAt(renSel, 2).toString(); // fecha_entrega
            String califFinal = datos.getValueAt(renSel, 3).toString(); // calificacionf

            String comentario = cnx.obtenerDato(
                    "SELECT comentariop FROM asignadas "
                    + "WHERE tareas_idtareas = '" + tareasId + "' "
                    + "AND alumnos_idalumnos = '" + alumnosId + "' "
                    + "AND fecha_entrega = '" + fechaEnt + "' ");

            String estado = cnx.obtenerDato(
                    "SELECT estado FROM asignadas "
                    + "WHERE tareas_idtareas = '" + tareasId + "' "
                    + "AND alumnos_idalumnos = '" + alumnosId + "' "
                    + "AND fecha_entrega = '" + fechaEnt + "' ");

            CBtarID.setSelectedItem(tareasId);
            CBaluID.setSelectedItem(alumnosId);
            TCali.setText(califFinal);
            TComen.setText(comentario != null ? comentario : "");

            if (estado != null) {
                CBEstado.setSelectedItem(estado);
            }

            if (fechaEnt != null && !fechaEnt.trim().isEmpty()) {
                DFecha.setDate(cnx.toDate(fechaEnt));
            } else {
                DFecha.setDate(null);
            }
        }
    }//GEN-LAST:event_TAsignadasMousePressed

    private void BBuscarAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBuscarAlumnosActionPerformed
        String calMin = TFiltroCalm.getText().trim(); // Ej: 80
        String estado = TFiltroEstado.getText().trim(); // Ej: ENTREGADA

        String sql = "SELECT tareas_idtareas, alumnos_idalumnos, calificacionf, estado "
                + "FROM asignadas WHERE 1=1 ";

        if (!calMin.isEmpty()) {
            sql += " AND calificacionf >= " + calMin;
        }
        if (!estado.isEmpty()) {
            sql += " AND estado LIKE '%" + estado + "%' ";
        }

        sql += " ORDER BY calificacionf DESC ";

        System.out.println("SQL BUSCAR ASIGNADAS: " + sql);
        cnx.entablar(sql, TAsignadas);

    }//GEN-LAST:event_BBuscarAlumnosActionPerformed

    private void BTOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTOrdenarActionPerformed
     String sql = "SELECT tareas_idtareas, alumnos_idalumnos, "
        + "fecha_entrega, calificacionf, estado "
        + "FROM asignadas "
        + "ORDER BY estado ASC, fecha_entrega DESC";

cnx.entablar(sql, TAsignadas);

    }//GEN-LAST:event_BTOrdenarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FAsignadas().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BActualizar;
    private javax.swing.JButton BAgregar;
    private javax.swing.JButton BBorrar;
    private javax.swing.JButton BBuscarAlumnos;
    private javax.swing.JButton BGrafica;
    private javax.swing.JButton BNuevo;
    private javax.swing.JButton BPdf;
    private javax.swing.JButton BTOrdenar;
    private javax.swing.JComboBox<String> CBEstado;
    private javax.swing.JComboBox<String> CBaluID;
    private javax.swing.JComboBox<String> CBtarID;
    private com.toedter.calendar.JDateChooser DFecha;
    private javax.swing.JPanel PFondo;
    private javax.swing.JPanel PFormulario;
    private javax.swing.JPanel PTitulo;
    private javax.swing.JTable TAsignadas;
    private javax.swing.JTextField TCali;
    private javax.swing.JTextField TComen;
    private javax.swing.JTextField TFiltroCalm;
    private javax.swing.JTextField TFiltroEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

    public int insertarAsignadaAPI(
            String tareasId,
            String alumnosId,
            String fechaEntrega, // "yyyy-MM-dd" o ""
            String comentario,
            String califFinal, // lo mandamos como texto
            String estado) {

        try {
            System.out.println("DEBUG insertarAsignadaAPI() *****");
            System.out.println("tareas_idtareas = " + tareasId);
            System.out.println("alumnos_idalumnos = " + alumnosId);
            System.out.println("fecha_entrega = " + fechaEntrega);
            System.out.println("comentariop = " + comentario);
            System.out.println("calificacionf = " + califFinal);
            System.out.println("estado = " + estado);

            StringBuilder postData = new StringBuilder();

            String[][] params = {
                {"key", "secret"},
                {"accion", "insertAsignada"},
                {"tareas_idtareas", tareasId},
                {"alumnos_idalumnos", alumnosId},
                {"fecha_entrega", fechaEntrega == null ? "" : fechaEntrega},
                {"comentariop", comentario == null ? "" : comentario},
                {"calificacionf", califFinal == null ? "" : califFinal},
                {"estado", estado == null ? "" : estado}
            };

            for (int i = 0; i < params.length; i++) {
                if (i > 0) {
                    postData.append('&');
                }
                postData.append(java.net.URLEncoder.encode(params[i][0], "UTF-8"));
                postData.append('=');
                postData.append(java.net.URLEncoder.encode(
                        params[i][1] == null ? "" : params[i][1], "UTF-8"));
            }

            byte[] postBytes = postData.toString().getBytes("UTF-8");

            java.net.URL u = new java.net.URL("http://gts220716711.webcindario.com/asignadas_api.php");
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection) u.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

            conn.getOutputStream().write(postBytes);

            java.io.InputStream is = conn.getInputStream();
            java.util.Scanner s = new java.util.Scanner(is, "UTF-8").useDelimiter("\\A");
            String respuesta = s.hasNext() ? s.next() : "";
            System.out.println("RESPUESTA API ASIGNADAS: [" + respuesta + "]");

            return respuesta.contains("OK") ? 1 : 0;

        } catch (Exception e) {
            System.out.println("Error API insertAsignada: " + e.getMessage());
            e.printStackTrace();
            return 0;
        }
    }

}
