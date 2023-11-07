package Lab_final;

import com.formdev.flatlaf.FlatLightLaf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Cultured extends javax.swing.JFrame {

    static ArrayList<ArrayList<String>> preguntas = new ArrayList<>();

    ArrayList<String> preguntaEscogida;
    ArrayList<String> Opciones = new ArrayList<>();
    String pregunta;
    String respuesta;
    int n_pregunta = 0;       // Con esta pregunta se inicia!
    Random num_random = new Random();
    int puntaje = 0;
    private int indice_pregunta;

    public void bancoPreguntas() {
        // <editor-fold defaultstate="collapsed" desc="Banco de preguntas"> 
        //Preguntas de Matematicas (0-9)
        preguntas.add(new ArrayList<>(Arrays.asList(
                "¿Cuál es la propiedad de la multiplicación que afirma a * b = b * a?",
                "Conmutativa", "Distributiva", "Asociativa", "Identidad")));

        preguntas.add(new ArrayList<>(Arrays.asList(
                "¿Cuál es el resultado de cualquier número multiplicado por 1?",
                "El mismo número", "0", "1", "Ninguna de las anteriores")));

        preguntas.add(new ArrayList<>(Arrays.asList(
                "Si a * (b * c) = (a * b) * c ¿qué propiedad se está demostrando?",
                "Asociativa", "Conmutativa", "Distributiva", "Identidad")));

        preguntas.add(new ArrayList<>(Arrays.asList(
                "Si a * (b + c) = a*b + a*c ¿qué propiedad se está demostrando?",
                "Distributiva", "Conmutativa", "Asociativa", "Identidad")));

        preguntas.add(new ArrayList<>(Arrays.asList(
                "¿Cuál es el resultado de cualquier número multiplicado por 0?",
                "0", "El mismo número", "1", "Ninguna de las anteriores")));

        preguntas.add(new ArrayList<>(Arrays.asList(
                "Si a/b = c entonces a = ?", "b * c", "b + c", "b - c", "c/b")));

        preguntas.add(new ArrayList<>(Arrays.asList(
                "¿Qué se obtiene al elevar un número a la potencia 0?",
                "1", "0", "El mismo número", "No se puede realizar esta operacion")));

        preguntas.add(new ArrayList<>(Arrays.asList(
                "¿Cuál es el resultado de la raíz cuadrada de un número elevado al cuadrado?",
                "El mismo número", "El número multiplicado por sí mismo", "0", "1")));

        preguntas.add(new ArrayList<>(Arrays.asList(
                "Si (a^b)^c = a^(b*c) ¿qué propiedad se está demostrando?", "Potencias de potencias",
                "Potencias de suma", "Potencias de producto",
                "Potencias de división")));

        preguntas.add(new ArrayList<>(Arrays.asList(
                "¿Cuál es el resultado de cualquier número dividido por 1?",
                "El mismo número", "0", "1", "Ninguna de las anteriores")));

        //Preguntas de Biologia celular basica (10-19)
        preguntas.add(new ArrayList<>(Arrays.asList(
                "¿Qué estructura celular contiene el material genético de la célula?",
                "Núcleo", "Lisosoma", "Mitocondria", "Ribosoma"
        )));

        preguntas.add(new ArrayList<>(Arrays.asList(
                "¿Cuál organelo es conocido como la 'central energética' de la célula?",
                "Mitocondria", "Núcleo", "Cloroplasto", "Aparato de Golgi"
        )));

        preguntas.add(new ArrayList<>(Arrays.asList(
                "¿Qué molécula es responsable de la síntesis de proteínas en la célula?",
                "ARNm", "ADN", "ARNt", "ARNr"
        )));

        preguntas.add(new ArrayList<>(Arrays.asList(
                "¿Cuál de las siguientes estructuras se encuentra principalmente en las células vegetales y no en las células animales?",
                "Cloroplasto", "Mitocondria", "Lisosoma", "Centríolo"
        )));

        preguntas.add(new ArrayList<>(Arrays.asList(
                "¿Qué estructura celular modifica, clasifica y empaqueta las proteínas?",
                "Aparato de Golgi", "Ribosoma", "Retículo endoplasmático rugoso", "Peroxisoma"
        )));

        preguntas.add(new ArrayList<>(Arrays.asList(
                "¿Cuál es la función principal de la membrana celular?",
                "Regulación del transporte de sustancias hacia adentro y hacia afuera de la célula",
                "Síntesis de proteínas", "Desintoxicación de la célula", "Producción de energía"
        )));

        preguntas.add(new ArrayList<>(Arrays.asList(
                "¿Qué organelos tienen su propio ADN y pueden replicarse de manera independiente?",
                "Mitocondrias y cloroplastos", "Lisosomas y peroxisomas",
                "Ribosomas y núcleo", "Retículo endoplasmático rugoso y liso"
        )));

        preguntas.add(new ArrayList<>(Arrays.asList(
                "¿Cómo se llaman las pequeñas estructuras que sintetizan las proteínas?",
                "Ribosomas", "Endosomas", "Vesículas", "Vacuolas"
        )));

        preguntas.add(new ArrayList<>(Arrays.asList(
                "¿Qué tipo de célula carece de un núcleo definido?",
                "Procariota", "Eucariota", "Mitocondria", "Ribosoma"
        )));

        preguntas.add(new ArrayList<>(Arrays.asList(
                "¿Qué estructura celular es responsable de la digestión y descomposición de materiales en la célula?",
                "Lisosoma", "Peroxisoma", "Aparato de Golgi", "Retículo endoplasmático liso"
        )));
        //Preguntas de Geografia (20-29)
        preguntas.add(new ArrayList<>(Arrays.asList(
                "¿Cuál es el río más largo del mundo?",
                "Amazonas", "Nilo", "Yangtsé", "Misisipi"
        )));

        preguntas.add(new ArrayList<>(Arrays.asList(
                "¿En qué continente se encuentra el desierto del Sahara?",
                "África", "Asia", "América del Norte", "Australia"
        )));

        preguntas.add(new ArrayList<>(Arrays.asList(
                "¿Qué país es conocido como el 'país del sol naciente'?",
                "Japón", "China", "Australia", "India"
        )));

        preguntas.add(new ArrayList<>(Arrays.asList(
                "¿Cuál es la capital de Francia?",
                "París", "Londres", "Berlín", "Madrid"
        )));

        preguntas.add(new ArrayList<>(Arrays.asList(
                "¿Qué montaña es la más alta del mundo?",
                "Monte Everest", "K2", "Monte Kilimanjaro", "Monte McKinley"
        )));

        preguntas.add(new ArrayList<>(Arrays.asList(
                "¿Qué océano es el más grande del mundo?",
                "Océano Pacífico", "Océano Atlántico", "Océano Índico", "Océano Ártico"
        )));

        preguntas.add(new ArrayList<>(Arrays.asList(
                "¿En qué país se encuentran las cataratas del Niágara?",
                "Canadá y Estados Unidos", "Brasil y Argentina", "Venezuela", "Zimbabwe y Zambia"
        )));

        preguntas.add(new ArrayList<>(Arrays.asList(
                "¿Cuál es la ciudad más poblada del mundo?",
                "Tokio", "Shanghái", "Nueva Delhi", "Ciudad de México"
        )));

        preguntas.add(new ArrayList<>(Arrays.asList(
                "¿Qué canal conecta el Océano Atlántico con el Océano Pacífico?",
                "Canal de Panamá", "Canal de Suez", "Canal del Midi", "Canal de la Mancha"
        )));

        preguntas.add(new ArrayList<>(Arrays.asList(
                "¿Cuál es el país con más fronteras terrestres?",
                "China y Rusia (empate)", "Brasil", "India", "Alemania"
        )));
        // </editor-fold>   

    }
    
    public void escogerPregunta(int n) {

        preguntaEscogida = preguntas.get(n);
        pregunta = preguntaEscogida.get(0);
        respuesta = preguntaEscogida.get(1);
        Opciones.clear();

        for (int i = 1; i < preguntaEscogida.size(); i++) {  // puedo cambiar de preguntaEscogida.size() a 5
            Opciones.add(preguntaEscogida.get(i));
        }
        Collections.shuffle(Opciones); //Aleatorio!
    }

    public void mostrarPregunta() {
        Enunciado.setBorder(null);
        Enunciado.setText(pregunta);
        String puntajeStr = String.valueOf(puntaje);
        Score.setText(puntajeStr);

        Opcion_1.setText(Opciones.get(0));
        Opcion_2.setText(Opciones.get(1));
        Opcion_3.setText(Opciones.get(2));
        Opcion_4.setText(Opciones.get(3));
    }

    void escogerRespuesta(int n) {
        if (Opciones.get(n).equals(respuesta)) {
            puntaje += 100;
            JOptionPane.showMessageDialog(this,
                    "Su respuesta es correcta!",
                    "Muy bien :)",
                    JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(this,
                    "La respuesta correcta es: " + respuesta,
                    "Que mal :C",
                    JOptionPane.ERROR_MESSAGE);
        }
        nextQuestion();

    }

    public void nextQuestion() {
        if (n_pregunta == 7) {
            Pan_Final pf = new Pan_Final();
            Controlador con = new Controlador();
            con.Show_jFrame(pf);
            abrirPanFinal();
            this.dispose();
        }

        if (this.indice_pregunta == 10) {
            int pregunta_random = num_random.nextInt(10);
            escogerPregunta(pregunta_random);
            mostrarPregunta();
            n_pregunta++;
        } else {
            if (this.indice_pregunta == 20) {
                int pregunta_random = num_random.nextInt(10) + 10;
                escogerPregunta(pregunta_random);
                mostrarPregunta();
                n_pregunta++;
            } else {
                int pregunta_random = num_random.nextInt(10) + 20;
                escogerPregunta(pregunta_random);
                mostrarPregunta();
                n_pregunta++;
            }
        }
    }

    public Cultured(int indice_pregunta) {
        this.indice_pregunta = indice_pregunta;
        FlatLightLaf.setup();
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);  //se puede cambiar!
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        bancoPreguntas();
        nextQuestion();
    }
    
    
    public int getPuntaje() {
    return puntaje;
}

    public void abrirPanFinal() {
        Pan_Final panFinal = new Pan_Final();
        int puntajeActual = getPuntaje(); // 
        panFinal.mostrarPuntaje(puntajeActual); // 
        panFinal.setVisible(true); // 
        dispose();
    }
    
  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Score = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Enunciado = new javax.swing.JTextPane();
        Opcion_1 = new javax.swing.JButton();
        Opcion_2 = new javax.swing.JButton();
        Opcion_4 = new javax.swing.JButton();
        Opcion_3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(138, 177, 125));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Score.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        Score.setForeground(new java.awt.Color(0, 0, 0));
        Score.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Score.setText("Puntuacion:");
        Score.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Enunciado.setFont(new java.awt.Font("Agency FB", 3, 24)); // NOI18N
        jScrollPane1.setViewportView(Enunciado);

        Opcion_1.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        Opcion_1.setText("Opcion 1");
        Opcion_1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Opcion_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Opcion_1ActionPerformed(evt);
            }
        });

        Opcion_2.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        Opcion_2.setText("Opcion 2");
        Opcion_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Opcion_2ActionPerformed(evt);
            }
        });

        Opcion_4.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        Opcion_4.setText("Opcion 4");
        Opcion_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Opcion_4ActionPerformed(evt);
            }
        });

        Opcion_3.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        Opcion_3.setText("Opcion 3");
        Opcion_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Opcion_3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Opcion_1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Opcion_4, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(Opcion_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(Opcion_2, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(Score, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(140, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(Score, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Opcion_2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Opcion_1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Opcion_4, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .addComponent(Opcion_3, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Opcion_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Opcion_1ActionPerformed
        escogerRespuesta(0);
    }//GEN-LAST:event_Opcion_1ActionPerformed

    private void Opcion_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Opcion_2ActionPerformed
        escogerRespuesta(1);
    }//GEN-LAST:event_Opcion_2ActionPerformed

    private void Opcion_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Opcion_4ActionPerformed
        escogerRespuesta(3);
    }//GEN-LAST:event_Opcion_4ActionPerformed

    private void Opcion_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Opcion_3ActionPerformed
        escogerRespuesta(2);
    }//GEN-LAST:event_Opcion_3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane Enunciado;
    private javax.swing.JButton Opcion_1;
    private javax.swing.JButton Opcion_2;
    private javax.swing.JButton Opcion_3;
    private javax.swing.JButton Opcion_4;
    private javax.swing.JLabel Score;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
