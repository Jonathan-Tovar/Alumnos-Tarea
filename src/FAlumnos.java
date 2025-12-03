
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class FAlumnos extends javax.swing.JFrame {

    ImageIcon icono = new ImageIcon(getClass().getResource("/img/pacientes.png"));

    //----------------------------------------------------------------------------------//
    String url = "http://gts220716711.webcindario.com/mysql.php";

    ConexionHR cnx = new ConexionHR(url);

    String alumnos = "SELECT idalumnos, nombrea, ciclo FROM alumnos ORDER BY nombrea ";

    String niveles = "SELECT MONTH(fecha_entrega) AS mes, AVG(calificacionf) AS promedio "
            + "FROM asignadas ";

    String grupo = "GROUP BY MONTH(fecha_entrega) ";
    //-------------------------------------------------------------------------------------//

    public FAlumnos() {
        initComponents();

        setLocationRelativeTo(this);
        this.setIconImage(icono.getImage());

        cnx.entablar(alumnos, TAlumnos);
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
        BOrdenar = new javax.swing.JButton();
        BNuevo = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        BAgregar = new javax.swing.JButton();
        BActualizar = new javax.swing.JButton();
        BBorrar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        BPdf = new javax.swing.JButton();
        BGrafica = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jLabel3 = new javax.swing.JLabel();
        TFiltroGrupo = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jLabel6 = new javax.swing.JLabel();
        TFiltroCiclo = new javax.swing.JTextField();
        BBuscarAlumnos = new javax.swing.JButton();
        PFormulario = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TNombre = new javax.swing.JTextField();
        Tid = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        CBEstado = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        TGmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        TGrupo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        TCiclo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TAlumnos = new javax.swing.JTable();
        PFondo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Universidad - Modulo de Alumnos");
        setBackground(new java.awt.Color(0, 0, 0));

        PTitulo.setBackground(new java.awt.Color(0, 0, 51));
        PTitulo.setLayout(null);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 153, 255));
        jLabel11.setText("Alumnos");
        PTitulo.add(jLabel11);
        jLabel11.setBounds(150, 8, 250, 40);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Modulo de Alumnos");
        PTitulo.add(jLabel9);
        jLabel9.setBounds(150, 50, 200, 20);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pacientes.png"))); // NOI18N
        PTitulo.add(jLabel8);
        jLabel8.setBounds(19, 17, 95, 60);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo.png"))); // NOI18N
        PTitulo.add(jLabel10);
        jLabel10.setBounds(0, 0, 1120, 90);

        jToolBar1.setRollover(true);

        BOrdenar.setText("ORDENAR");
        BOrdenar.setFocusable(false);
        BOrdenar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BOrdenar.setMaximumSize(new java.awt.Dimension(100, 70));
        BOrdenar.setMinimumSize(new java.awt.Dimension(100, 70));
        BOrdenar.setPreferredSize(new java.awt.Dimension(100, 70));
        BOrdenar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BOrdenarActionPerformed(evt);
            }
        });
        jToolBar1.add(BOrdenar);

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

        jLabel3.setText("GRUPO:");
        jToolBar1.add(jLabel3);

        TFiltroGrupo.setMaximumSize(new java.awt.Dimension(150, 50));
        TFiltroGrupo.setMinimumSize(new java.awt.Dimension(150, 50));
        TFiltroGrupo.setPreferredSize(new java.awt.Dimension(150, 50));
        jToolBar1.add(TFiltroGrupo);
        jToolBar1.add(jSeparator4);

        jLabel6.setText("CICLO:");
        jToolBar1.add(jLabel6);

        TFiltroCiclo.setMaximumSize(new java.awt.Dimension(150, 50));
        TFiltroCiclo.setMinimumSize(new java.awt.Dimension(150, 50));
        TFiltroCiclo.setPreferredSize(new java.awt.Dimension(150, 50));
        jToolBar1.add(TFiltroCiclo);

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
        jLabel1.setText("IDALUMNOS:");

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(78, 80, 82));
        jLabel2.setText("NOMBRE:");

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(78, 80, 82));
        jLabel4.setText("ESTADO:");

        CBEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACTIVO", "INACTIVO", "BAJA" }));

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(78, 80, 82));
        jLabel5.setText("GMAIL:");

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(78, 80, 82));
        jLabel7.setText("GRUPO:");

        jLabel12.setBackground(new java.awt.Color(204, 204, 204));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(78, 80, 82));
        jLabel12.setText("CICLO:");

        javax.swing.GroupLayout PFormularioLayout = new javax.swing.GroupLayout(PFormulario);
        PFormulario.setLayout(PFormularioLayout);
        PFormularioLayout.setHorizontalGroup(
            PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PFormularioLayout.createSequentialGroup()
                .addGroup(PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PFormularioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tid, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PFormularioLayout.createSequentialGroup()
                        .addGroup(PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PFormularioLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(TGmail, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PFormularioLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(PFormularioLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PFormularioLayout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
            .addGroup(PFormularioLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PFormularioLayout.setVerticalGroup(
            PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PFormularioLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Tid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TGmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(TCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(CBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(PFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        TAlumnos.setModel(new javax.swing.table.DefaultTableModel(
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
        TAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TAlumnosMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(TAlumnos);

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
                .addGap(18, 18, 18)
                .addComponent(PFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 1183, Short.MAX_VALUE)
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
        String id = Tid.getText();
        String query = niveles + "WHERE alumnos_idalumnos = '" + id + "' " + grupo;

        int ok = cnx.crearPDF("Tarea", "Promedio Mensual de Tareas",
                query, new float[]{0.5f, 0.5f}, "promedio_mensual");

        if (ok == 1) {
            cnx.visualizarPDF("promedio_mensual");

        } else {
            System.out.println("PDF no generado");
        }
    }//GEN-LAST:event_BPdfActionPerformed

    private void BNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BNuevoActionPerformed
        Tid.setText("");
        TNombre.setText("");
        CBEstado.setSelectedIndex(0);
        TGmail.setText("");
        TCiclo.setText("");
        TGrupo.setText("");

    }//GEN-LAST:event_BNuevoActionPerformed

    private void BGraficaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BGraficaActionPerformed
        String id = Tid.getText();
        String query = niveles + "WHERE alumnos_idalumnos = '" + id + "' " + grupo;

        ArrayList<String> series = new ArrayList();
        ArrayList<ArrayList<String>> datos = new ArrayList();

        datos = cnx.consultar(query);

        series.add(id);

        GraficaXY graf = new GraficaXY("Promedio Mensual de Tareas", "Meses", "Promedio", series, datos);

        PFondo.removeAll();
        PFondo.add(graf.chartPanel);
        PFondo.updateUI();

    }//GEN-LAST:event_BGraficaActionPerformed

    private void BAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAgregarActionPerformed
        String id = Tid.getText().trim();
        String nom = TNombre.getText().trim();
        String ciclo = TCiclo.getText().trim();
        String grupo = TGrupo.getText().trim();
        String email = TGmail.getText().trim();
        String estado = CBEstado.getSelectedItem().toString();

        if (id.isEmpty() || nom.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "ID y Nombre son obligatorios.",
                    "Datos incompletos",
                    javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        int ok = insertarAlumnoAPI(id, nom, ciclo, grupo, email, estado);

        if (ok == 1) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Alumno agregado correctamente.",
                    "Éxito",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);

            // Recargar la tabla de alumnos
            String consulta = "SELECT idalumnos, nombrea, ciclo FROM alumnos ORDER BY nombrea";
            cnx.entablar(consulta, TAlumnos);

        } else {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "No se pudo agregar el alumno. Revisa la consola (RESPUESTA API).",
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_BAgregarActionPerformed

    private void BActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BActualizarActionPerformed
        String id = Tid.getText();
        String nom = TNombre.getText();
        String ciclo = TCiclo.getText();
        String gru = TGrupo.getText();
        String gm = TGmail.getText();
        String estado = CBEstado.getSelectedItem().toString();

        String[] valores = new String[]{id, nom, ciclo, gru, gm, estado};

        cnx.actualizar("alumnos", valores);
        cnx.entablar(alumnos, TAlumnos);

    }//GEN-LAST:event_BActualizarActionPerformed

    private void BBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBorrarActionPerformed
        String id = Tid.getText();
        String nom = TNombre.getText();
        String ciclo = TCiclo.getText();
        String estado = CBEstado.getSelectedItem().toString();
        String gm = TGmail.getText();
        String gru = TGrupo.getText();

        String[] valores = new String[]{id, nom, ciclo, estado, gm, gru};

        cnx.borrar("alumnos", valores);
        cnx.entablar(alumnos, TAlumnos);

    }//GEN-LAST:event_BBorrarActionPerformed

    private void TAlumnosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TAlumnosMousePressed
        DefaultTableModel datos = (DefaultTableModel) TAlumnos.getModel();
        int renSel = TAlumnos.getSelectedRow();

        if (renSel > -1) {
            String id = datos.getValueAt(renSel, 0).toString();
            String nom = datos.getValueAt(renSel, 1).toString();
            String ciclo = datos.getValueAt(renSel, 2).toString();
            String estado = cnx.obtenerDato("SELECT estatus FROM alumnos WHERE idalumnos = '" + id + "' ");
            String gm = cnx.obtenerDato("SELECT email FROM alumnos WHERE idalumnos = '" + id + "' ");
            String gru = cnx.obtenerDato("SELECT grupo FROM alumnos WHERE idalumnos = '" + id + "' ");

            Tid.setText(id);
            TNombre.setText(nom);
            TCiclo.setText(ciclo);
            CBEstado.setSelectedItem(estado);
            TGmail.setText(gm);
            TGrupo.setText(gru);

        }

    }//GEN-LAST:event_TAlumnosMousePressed

    private void BBuscarAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBuscarAlumnosActionPerformed
        String grupo = TFiltroGrupo.getText().trim();
        String ciclo = TFiltroCiclo.getText().trim();

        String sql = "SELECT idalumnos, nombrea, ciclo "
                + "FROM alumnos "
                + "WHERE 1 = 1 ";

        // Filtro por grupo
        if (!grupo.isEmpty()) {
            sql += " AND grupo = '" + grupo + "'";
        }

        // Filtro por ciclo
        if (!ciclo.isEmpty()) {
            sql += " AND ciclo = '" + ciclo + "'";
        }

        sql += " ORDER BY grupo, nombrea";

        System.out.println("SQL filtro alumnos: " + sql);
        cnx.entablar(sql, TAlumnos);
    }//GEN-LAST:event_BBuscarAlumnosActionPerformed

    private void BOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BOrdenarActionPerformed
        String sql = "SELECT idalumnos, nombrea, ciclo "
                + "FROM alumnos "
                + "ORDER BY ciclo, nombrea ";

        cnx.entablar(sql, TAlumnos);
    }//GEN-LAST:event_BOrdenarActionPerformed

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
                new FAlumnos().setVisible(true);
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
    private javax.swing.JButton BOrdenar;
    private javax.swing.JButton BPdf;
    private javax.swing.JComboBox<String> CBEstado;
    private javax.swing.JPanel PFondo;
    private javax.swing.JPanel PFormulario;
    private javax.swing.JPanel PTitulo;
    private javax.swing.JTable TAlumnos;
    private javax.swing.JTextField TCiclo;
    private javax.swing.JTextField TFiltroCiclo;
    private javax.swing.JTextField TFiltroGrupo;
    private javax.swing.JTextField TGmail;
    private javax.swing.JTextField TGrupo;
    private javax.swing.JTextField TNombre;
    private javax.swing.JTextField Tid;
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
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

    public int insertarAlumnoAPI(
            String id, String nombre,
            String ciclo, String grupo,
            String email, String estatus) {

        try {
            System.out.println("DEBUG insertarAlumnoAPI() ********");
            System.out.println("id=" + id);
            System.out.println("nombre=" + nombre);
            System.out.println("ciclo=" + ciclo);
            System.out.println("grupo=" + grupo);
            System.out.println("email=" + email);
            System.out.println("estatus=" + estatus);

            StringBuilder postData = new StringBuilder();

            String[][] params = {
                {"key", "secret"},
                {"accion", "insertAlumno"},
                {"idalumnos", id},
                {"nombrea", nombre},
                {"ciclo", ciclo},
                {"grupo", grupo},
                {"email", email},
                {"estatus", estatus}
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

            java.net.URL u = new java.net.URL("http://gts220716711.webcindario.com/alumnos_api.php");
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection) u.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            conn.getOutputStream().write(postBytes);

            java.io.InputStream is = conn.getInputStream();
            java.util.Scanner s = new java.util.Scanner(is, "UTF-8").useDelimiter("\\A");
            String respuesta = s.hasNext() ? s.next() : "";
            System.out.println("RESPUESTA API: [" + respuesta + "]");

            return respuesta.contains("OK") ? 1 : 0;

        } catch (Exception e) {
            System.out.println("Error API insertAlumno: " + e.getMessage());
            e.printStackTrace(); // para ver el detalle exacto
            return 0;
        }
    }

}
