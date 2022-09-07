package com.example.proyectodawfa;

import com.example.proyectodawfa.modelo.clases.Oferta;
import com.example.proyectodawfa.modelo.clases.OfertaModelo;
import com.example.proyectodawfa.modelo.clases.Usuario;
import com.example.proyectodawfa.modelo.dao.OfertasDAO;
import com.example.proyectodawfa.modelo.ficheros.EscrituraFichero;
import com.example.proyectodawfa.modelo.ficheros.LecturaFichero;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class OfertasController implements Initializable {

    @FXML
    private TableView<OfertaModelo> tblOfertas;
    @FXML
    private TableColumn<OfertaModelo, String> colNombreOferta;
    @FXML
    private TableColumn<OfertaModelo, String> colFechaInicio;
    @FXML
    private TableColumn<OfertaModelo, String> colFechaFinal;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Lista Oferta -- ObservableList -- columnas

        //creamos lista de Ofertas
        List<Oferta> ofertaList = OfertasDAO.seleccionarOfertas();
        //creamos observableList
        ObservableList<OfertaModelo> ofertaModeloObservableList = FXCollections.observableArrayList();
        //de la clase Oferta, el elem, de la lista
        for(Oferta o: ofertaList){ //de cada elem de la lista normal
            ofertaModeloObservableList.add(new OfertaModelo(o.getNombreOferta(),o.getFechaInicio(),o.getFechaFinal() )); //guardamos en la observable los q nos interesa para la tabla
        }
        //insertamos datos en columnas
        colNombreOferta.setCellValueFactory(cellData -> cellData.getValue().getNombreOferta());
        colFechaInicio.setCellValueFactory(cellData -> cellData.getValue().getFechaInicio().asString());
        colFechaFinal.setCellValueFactory(cellData -> cellData.getValue().getFechaFinal().asString());
        //cambiamos items de la tabla
        tblOfertas.setItems(ofertaModeloObservableList);
    }

    //escribir fichero
    static List <String> contenido = new ArrayList<String>(); //lista contenido
    public void escOferta(ActionEvent actionEvent) {
        inicializarContenido();
        // aqui se crea el fichero
        EscrituraFichero.escribirFicheroCompleto("Files/folleto.txt",contenido); //mandamos carpeta y nombre con el q se guardara y contenido
    }

    public static void inicializarContenido() {
        contenido.add("\t Tenemos buenas noticias para ti "); //agregamos escritos a la lista contenido
        contenido.add("\t Realiza una compra en el mes de abril y recibe un 10% de descuento! ");
        contenido.add("\t Entra en nuestra pag web para mas informacion");
        contenido.add("\t Muchas gracias por tu confianza");
        contenido.add("\t ----- Tienda VentaPC -----");
    }

    //leer fichero
    static List <String> contenidoLeido = new ArrayList<String>();
    public void leerOferta(ActionEvent actionEvent) {
        String nombre, telefono;
        String [] elementos; //creamos array de elementos
        List <Usuario> listaUsuario = new ArrayList<Usuario>(); // creamos lista municipios

        contenidoLeido = LecturaFichero.lecturaCompletaLineas("Files/listadoCSV.csv", StandardCharsets.UTF_8); //leer - mandamos fichero csv que hemos descargado y charset

        for(String linea: contenidoLeido) { //por cada linea
            elementos = linea.split(","); //guarda en el array 1 elem x coma
            if (elementos.length==5) {
                nombre= elementos[2]+" "+ elementos[1];
                nombre= nombre.replace("\"", ""); //quita comillas
                nombre= nombre.trim(); // quita espacios
                telefono= elementos[3];
            }else {
                nombre=elementos[1];
                telefono= elementos[2];
            }
            listaUsuario.add(new Usuario(nombre,telefono)); //add Usuario
            List <String> contenidoDos;
            contenidoDos = listaUsuario.stream().map(x -> x.getNombre() + " " + x.getTelefono()).collect(Collectors.toList()); //aqui?
            EscrituraFichero.escribirFicheroCompleto("Files/listadoUsuarios.txt", contenidoDos); //inventarnos nombre de nuevo archivo txt con la info recogida del csv
        }
        listaUsuario.forEach(m -> System.out.println(m.getNombre()+" "+m.getTelefono()));
    }
}
