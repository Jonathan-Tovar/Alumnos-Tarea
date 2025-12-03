
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author drlias
 */
public class ConexionHR {

    String url; //URL al archivo mysql.php del servidor

    public ConexionHR(String url) {
        this.url = url;
    }

    //=========================================================================
    // <editor-fold defaultstate="collapsed" desc="Funciones Solicitudes a BD">   
    //--------------------------------------------------------------------------
    //-------- Muestra el resultado de una consulta en una JTable
    //--------------------------------------------------------------------------
    public int entablar(String consulta, JTable malla) {

        int correcta = 0;

        String resultado = peticionHttpPost(url, consulta);

        if (resultado != null) {

            String[] lineas = resultado.split("->");

            DefaultTableModel modelo = (DefaultTableModel) malla.getModel();
            //limpiar tabla
            modelo.setColumnCount(0);
            modelo.setRowCount(0);

            //agregar las columnas del resultado con su nombre
            String cols[] = lineas[0].split(",");
            for (String col : cols) {
                modelo.addColumn(col.toUpperCase());
            }

            //agregar renglones con los datos
            for (int k = 1; k < lineas.length; k++) {
                String ren[] = lineas[k].split(",");
                modelo.addRow(ren);
            }

            correcta = 1;
        }

        return correcta;

    }

    //--------------------------------------------------------------------------
    //-------- muestra los datos de un campo en un combobox
    //--------------------------------------------------------------------------
    public int seleccionar(String consulta, JComboBox box) {
        int correcta = 1;
        ArrayList<String> datos = new ArrayList();
        String[] lineas = null;

        try {
            String resultado = peticionHttpPost(url, consulta);
            if (resultado != null) {
                lineas = resultado.split("->");
                for (int k = 1; k < lineas.length; k++) {
                    datos.add(lineas[k]);
                }

                DefaultComboBoxModel cbm = new DefaultComboBoxModel(datos.toArray());
                box.setModel(cbm);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            correcta = 0;
        }
        return correcta;
    }

    //--------------------------------------------------------------------------
    //-------- regresa el valor de una consulta de un solo dato
    //-------- si el resultado es la cadena vacia, significa que la consulta ha
    //-------- regresado una tabla vacia o el código SQL es incorrecto
    //--------------------------------------------------------------------------
    public String obtenerDato(String consulta) {

        String dato = "";

        try {
            String resultado = peticionHttpPost(url, consulta);
            if (resultado != null) {
                String[] lineas = resultado.split("->");
                if (lineas.length > 1) {
                    dato = lineas[1];
                }

            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());;
        }

        return dato;
    }

    //--------------------------------------------------------------------------
    //-------- regresa el valor de un campo que coincida con un dato dado
    //-------- supone que el campo regresado por la consulta es único
    //--------------------------------------------------------------------------
    public String buscarDato(String tabla, String columnaDeseada, String campoBuscado, String valorBuscado) {
        String consulta = "SELECT " + columnaDeseada + " FROM " + tabla
                + " WHERE " + campoBuscado + " = '" + valorBuscado + "'";

        String dato = "";

        try {
            String resultado = peticionHttpPost(url, consulta);
            if (resultado != null) {
                String[] lineas = resultado.split("->");
                if (lineas.length > 1) {
                    dato = lineas[1];
                }

            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());;
        }

        return dato;
    }

    //--------------------------------------------------------------------------
    //-------- regresa una lista con los registros del resultado de la consulta
    //---------cada registro de la lista es otra lista que contiene los datos del registro
    //--------------------------------------------------------------------------
    public ArrayList<ArrayList<String>> consultar(String consulta) {
        ArrayList<ArrayList<String>> datos = new ArrayList();

        String resultado = peticionHttpPost(url, consulta);

        if (resultado != null) {

            String[] lineas = resultado.split("->");

            for (int idx = 1; idx < lineas.length; idx++) {
                String linea = lineas[idx];
                ArrayList<String> renglon = new ArrayList();
                String[] valores = linea.split(",");
                for (Object elem : valores) {
                    renglon.add(elem.toString());
                }
                datos.add(renglon);
            }

        }

        return datos;
    }

    // </editor-fold>
    //=========================================================================
    // <editor-fold defaultstate="collapsed" desc="Funciones PDF">   
    //-------------------------------------------------
    //Crea un archivo PDF en base a una consulta dada
    //-------------------------------------------------
    public int crearPDF(String titulo, String encabezado, String consulta, float[] anchos, String nombreReporte) {
        int correcta = 0;
        String resultado = null;

        try {
            resultado = peticionHttpPost(url, consulta);
        } catch (Exception e) {
            System.out.println("Error al consultar servidor: " + e.getMessage());
            javax.swing.JOptionPane.showMessageDialog(null,
                    "No se pudo obtener datos del servidor para el PDF.\n"
                    + "Mensaje: " + e.getMessage(),
                    "Error de conexión",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            return 0;
        }

        if (resultado == null || resultado.trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(null,
                    "El servidor no regresó datos para el PDF.\n"
                    + "Verifica que la consulta tenga resultados.",
                    "Sin datos",
                    javax.swing.JOptionPane.WARNING_MESSAGE);
            return 0;
        }

        try {
            Document doc = new Document();
            String[] lineas = resultado.split("->");

            PdfWriter.getInstance(doc, new FileOutputStream(nombreReporte + ".pdf"));
            doc.open();

            // Título
            doc.add(new Paragraph(titulo,
                    FontFactory.getFont(FontFactory.TIMES_BOLD, 18, Font.BOLD, BaseColor.BLACK)));
            doc.add(new Paragraph(obtenerFechaHoraE()));
            doc.add(Chunk.NEWLINE);
            doc.add(new Paragraph(
                    " - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - "));
            doc.add(Chunk.NEWLINE);
            doc.add(Chunk.NEWLINE);

            String cols[] = lineas[0].split(",");
            int numCols = cols.length;

            PdfPTable tbl = new PdfPTable(numCols);
            tbl.setTotalWidth(550f);
            tbl.setLockedWidth(true);
            tbl.setHorizontalAlignment(Element.ALIGN_CENTER);
            tbl.setWidths(anchos);
            tbl.setHeaderRows(2);

            // Encabezado de la tabla
            PdfPCell cell = new PdfPCell(new Phrase(encabezado));
            cell.setColspan(numCols);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(new BaseColor(51, 153, 255));
            tbl.addCell(cell);

            // Encabezados de columnas
            for (String col : cols) {
                PdfPCell celda = new PdfPCell(new Phrase(col.toUpperCase()));
                celda.setBackgroundColor(new BaseColor(153, 204, 255));
                tbl.addCell(celda);
            }

            // Registros
            for (int k = 1; k < lineas.length; k++) {
                String ren[] = lineas[k].split(",");
                for (String valor : ren) {
                    tbl.addCell(valor);
                }
            }

            doc.add(tbl);
            correcta = 1;
            doc.close();

        } catch (Exception ex) {
            System.out.println("Error al generar PDF: " + ex.getMessage());
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Ocurrió un error al generar el PDF:\n" + ex.getMessage(),
                    "Error al generar PDF",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            correcta = 0;
        }

        return correcta;
    }

    //-----------------------------------------------
    //Visualizar un archivo pdf
    //-----------------------------------------------
    public void visualizarPDF(String archivo) {
        try {
            File path = new File(archivo + ".pdf");
            Desktop.getDesktop().open(path);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // </editor-fold> 
    //=========================================================================
    // <editor-fold defaultstate="collapsed" desc="Funciones de fechas">   
    //========================================================================
    //--------------------------------------------------------------------------
    //-------- obtener la fechay hora del sistema
    //--------------------------------------------------------------------------
    public String obtenerFechaHora() {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        int mHour = c.get(Calendar.HOUR_OF_DAY);
        int mMinute = c.get(Calendar.MINUTE);
        int mSecond = c.get(Calendar.SECOND);
        int mMili = c.get(Calendar.MILLISECOND);

        return year + "-" + month + "-" + day + " " + mHour + ":" + mMinute + ":" + mSecond + "." + mMili;
    }

    //========================================================================
    //--------------------------------------------------------------------------
    //-------- obtener la fechay hora del sistema
    //--------------------------------------------------------------------------
    public String obtenerFechaHoraE() {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        int mHour = c.get(Calendar.HOUR_OF_DAY);
        int mMinute = c.get(Calendar.MINUTE);
        int mSecond = c.get(Calendar.SECOND);
        int mMili = c.get(Calendar.MILLISECOND);

        return day + "/" + month + "/" + year + " " + mHour + ":" + mMinute + ":" + mSecond;
    }

    //--------------------------------------------------------------------------
    //-------- obtener la fecha del sistema
    //--------------------------------------------------------------------------
    public String obtenerFecha() {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DAY_OF_MONTH);

        return year + "-" + month + "-" + day;
    }

    //--------------------------------------------------------------------------
    //-------- convertir fecha util a fecha SQL
    //--------------------------------------------------------------------------
    public String toSQL(java.util.Date fecha) {
        if (fecha == null) {
            return null;   // o "" si prefieres
        }
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(fecha);
    }

    //--------------------------------------------------------------------------
    //-------- convertir fecha Sql a fecha util
    //--------------------------------------------------------------------------
    public java.util.Date toDate(String fecha) {
        if (fecha == null) {
            return null;
        }
        fecha = fecha.trim();
        if (fecha.isEmpty()) {
            return null;
        }

        // lo que ya tenías:
        // suponiendo formato "yyyy-MM-dd"
        String[] partes = fecha.split("-");
        int anio = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]) - 1; // Calendar usa 0-11
        int dia = Integer.parseInt(partes[2]);

        Calendar cal = Calendar.getInstance();
        cal.set(anio, mes, dia);
        return cal.getTime();
    }

    //--------------------------------------------------------------------------
    //-------- obtener la hora del sistema
    //--------------------------------------------------------------------------
    public String obtenerHora() {
        Calendar c = Calendar.getInstance();
        int mHour = c.get(Calendar.HOUR_OF_DAY);
        int mMinute = c.get(Calendar.MINUTE);
        int mSecond = c.get(Calendar.SECOND);
        int mMili = c.get(Calendar.MILLISECOND);

        return mHour + ":" + mMinute + ":" + mSecond + "." + mMili;
    }

    // </editor-fold> 
    //=========================================================================
    // <editor-fold defaultstate="collapsed" desc="Funciones para peticiones">   
    public String peticionHttpPost(String url_visitar, String query) {
        try {

            URL urlv = new URL(url_visitar);

            Map<String, Object> params = new LinkedHashMap();
            params.put("key", "secret");
            params.put("query", query);

            StringBuilder postdata = new StringBuilder();
            for (Map.Entry<String, Object> param : params.entrySet()) {
                if (postdata.length() != 0) {
                    postdata.append("&");
                }
                postdata.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postdata.append("=");
                postdata.append(URLEncoder.encode(param.getValue().toString(), "UTF-8"));
            }

            byte[] postbytes = postdata.toString().getBytes("UTF-8");

            HttpURLConnection con = (HttpURLConnection) urlv.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setRequestProperty("Content-Length", "" + postbytes.length);
            con.setDoOutput(true);
            con.getOutputStream().write(postbytes);

            //------------
            BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String linea;
            StringBuilder resultado = new StringBuilder();
            while ((linea = rd.readLine()) != null) {
                if (resultado.length() != 0) {
                    resultado.append("->");
                }
                resultado.append(linea);
            }
            rd.close();
            return resultado + "";

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }

    }

    //-----------------------
    public static String peticionHttpGet(String url) throws Exception {
        // Esto es lo que vamos a devolver
        StringBuilder resultado = new StringBuilder();
        // Crear un objeto de tipo URL
        URL urlv = new URL(url);

        // Abrir la conexión e indicar que será de tipo GET
        HttpURLConnection conexion = (HttpURLConnection) urlv.openConnection();
        conexion.setRequestMethod("GET");
        // Búferes para leer
        BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        String linea;
        // Mientras el BufferedReader se pueda leer, agregar contenido a resultado
        while ((linea = rd.readLine()) != null) {
            resultado.append(linea);
        }
        // Cerrar el BufferedReader
        rd.close();
        // Regresar resultado, pero como cadena, no como StringBuilder
        return resultado.toString();
    }
    // </editor-fold> 

    //=========================================================================
    //-------------------------------------------------------
    //---Obtiene los nombres de las columnas de una tabla
    //-------------------------------------------------------
    public String[] columnas(String tabla) {
        String consulta = "SELECT * FROM " + tabla;
        String[] columnas = null;
        try {
            String resultado = peticionHttpPost(url, consulta);
            if (resultado != null) {
                String[] lineas = resultado.split("->");
                columnas = lineas[0].split(",");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return columnas;
    }

    //-------------------------------------------------------
    //---Insertar un registro en una tabla
    //-------------------------------------------------------
    public int insertar(String tabla, String[] valores) {
        int correcta = 0;

        // 1) Armar el SQL INSERT
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ").append(tabla).append(" VALUES(");

        for (int k = 0; k < valores.length; k++) {
            String v = valores[k];

            if (v == null || v.trim().isEmpty()) {
                // si es null o vacío -> NULL en SQL
                sb.append("NULL");
            } else {
                // escapamos comillas simples por si acaso
                v = v.replace("'", "''");
                sb.append("'").append(v).append("'");
            }

            if (k < valores.length - 1) {
                sb.append(",");
            }
        }
        sb.append(")");

        String sql = sb.toString();
        System.out.println("INSERTAR: " + sql);

        // 2) Enviar el SQL al PHP
        String resultado = null;
        try {
            resultado = peticionHttpPost(url, sql);
        } catch (Exception e) {
            System.out.println("Error al insertar: " + e.getMessage());
            javax.swing.JOptionPane.showMessageDialog(null,
                    "No se pudo conectar al servidor para insertar.\n"
                    + "Mensaje: " + e.getMessage(),
                    "Error de conexión",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            return 0;
        }

        // 3) Verificar respuesta
        if (resultado == null) {
            javax.swing.JOptionPane.showMessageDialog(null,
                    "El servidor no regresó respuesta al intentar insertar.\n"
                    + "Revisa la conexión o el script mysql.php.",
                    "Sin respuesta",
                    javax.swing.JOptionPane.WARNING_MESSAGE);
            return 0;
        }

        System.out.println("RESPUESTA INSERTAR: " + resultado);

        // Aquí depende de cómo responda tu mysql.php
        // muchos scripts devuelven algo como "OK" o "1"
        if (resultado.contains("AFFECTED ROWS")) {
            correcta = 1;
        } else {
            // por si el script devuelve un mensaje de error
            javax.swing.JOptionPane.showMessageDialog(null,
                    "El servidor respondió pero no confirmó el INSERT:\n" + resultado,
                    "INSERT no confirmado",
                    javax.swing.JOptionPane.WARNING_MESSAGE);
        }

        return correcta;
    }

    //-------------------------------------------------------
    //---Actualizar un registro en una tabla
    //-------------------------------------------------------
    public int actualizar(String tabla, String[] valores) {
         int correcta = 0;

    // Elegimos las columnas según la tabla
    String[] cols = null;

    switch (tabla) {
        case "alumnos":
            cols = new String[]{
                "idalumnos",
                "nombrea",
                "ciclo",
                "grupo",
                "email",
                "estatus"
            };
            break;

        case "tareas":
            cols = new String[]{
                "idtareas",
                "nombret",
                "materia",
                "calificacion",
                "fecha_asignada",
                "fecha_limite",
                "indicaciones"
            };
            break;

        case "asignadas":
            cols = new String[]{
                "tareas_idtareas",
                "alumnos_idalumnos",
                "fecha_entrega",
                "comentariop",
                "calificacionf",
                "estado"
            };
            break;
    }

    // Si no se reconoció la tabla, salimos
    if (cols == null) {
        System.out.println("Tabla no soportada en actualizar(): " + tabla);
        return 0;
    }

    // Armamos el UPDATE
    String sql = "UPDATE " + tabla + " SET ";
    for (int k = 1; k < valores.length; k++) {
        sql += cols[k] + " = '" + valores[k] + "'";
        if (k < valores.length - 1) {
            sql += ",";
        }
    }

    // 🔥 IMPORTANTE → asignadas tiene clave compuesta (2 campos)
    if (tabla.equals("asignadas")) {
        sql += " WHERE tareas_idtareas = '" + valores[0] + "'"
             + " AND alumnos_idalumnos = '" + valores[1] + "'";
    } else {
        sql += " WHERE " + cols[0] + " = '" + valores[0] + "'";
    }

    System.out.println("ACTUALIZAR: " + sql);

    try {
        String resultado = peticionHttpPost(url, sql);

        if (resultado != null && resultado.contains("AFFECTED ROWS")) {
            correcta = 1;
        }

        System.out.println("Resultado: " + resultado);
    } catch (Exception e) {
        System.out.println("Error en actualizar(): " + e.getMessage());
    }

    return correcta;
    }

    //-------------------------------------------------------
    //---Borra el registro en una tabla
    //-------------------------------------------------------
    public int borrar(String tabla, String[] valores) {
        int correcta = 0;

        String[] cols = columnas(tabla);

        if (cols == null) {
            System.out.println("Tabla no soportada en borrar(): " + tabla);
            return 0;
        }

        String sql = "DELETE FROM " + tabla
                + " WHERE " + cols[0] + " = '" + valores[0] + "'";

        System.out.println("BORRAR: " + sql);

        try {
            String resultado = peticionHttpPost(url, sql);

            if (resultado != null && resultado.contains("AFFECTED ROWS")) {
                correcta = 1;
            } else {
                System.out.println("Respuesta borrar(): " + resultado);
            }
        } catch (Exception e) {
            System.out.println("Error en borrar(): " + e.getMessage());
        }

        return correcta;
    }

    public int borrarTareaAPI(String idTarea) {
        try {
            StringBuilder postData = new StringBuilder();

            String[][] params = {
                {"key", "secret"},
                {"accion", "deleteTarea"},
                {"idtareas", idTarea}
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

            java.net.URL u = new java.net.URL("http://gts220716711.webcindario.com/tareas_api.php");
            java.net.HttpURLConnection conn
                    = (java.net.HttpURLConnection) u.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            conn.getOutputStream().write(postBytes);

            java.io.InputStream is = conn.getInputStream();
            java.util.Scanner s
                    = new java.util.Scanner(is, "UTF-8").useDelimiter("\\A");
            String respuesta = s.hasNext() ? s.next() : "";
            System.out.println("RESPUESTA borrarTareaAPI: " + respuesta);

            return (respuesta != null && respuesta.contains("OK")) ? 1 : 0;

        } catch (Exception e) {
            System.out.println("Error borrarTareaAPI: " + e.getMessage());
            return 0;
        }
    }

}
