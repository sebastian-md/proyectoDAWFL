package com.example.proyectodawfa;

import com.example.proyectodawfa.modelo.clases.Pedido;
import com.example.proyectodawfa.modelo.clases.PedidoModelo;
import com.example.proyectodawfa.modelo.clases.Usuario;
import com.example.proyectodawfa.modelo.dao.PedidosDAO;
import com.example.proyectodawfa.modelo.dao.UsuariosDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class UsuarioPedidoController<Pedido> implements Initializable {

    //combo
    @FXML
    private ComboBox<String> cmbUsuarios; //combo
    List<String> listaNombreUsuarios; //combo

    //tabla
    @FXML
    private TableColumn<PedidoModelo, Number> idIdPedido;
    @FXML
    private TableColumn<PedidoModelo, String> idNombrePedido;
    @FXML
    private TableColumn<PedidoModelo, String> idEstado;
    @FXML
    private TableColumn<PedidoModelo, String> idUsuario;
    @FXML
    private TableView<PedidoModelo> idTabla;
    //tabla & cambio combo
    ObservableList<PedidoModelo> pedidoModeloObservableList;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //combo
        List<Usuario> usuarioList = UsuariosDAO.seleccionarUsuarios();
        listaNombreUsuarios = usuarioList.stream().map(Usuario::getNombre).collect(Collectors.toList());
        cmbUsuarios.getItems().addAll(listaNombreUsuarios);

        //tabla

        List<com.example.proyectodawfa.modelo.clases.Pedido> pedidoList;
        pedidoList = PedidosDAO.seleccionarPedidos();
        pedidoModeloObservableList = FXCollections.observableArrayList();

        for (com.example.proyectodawfa.modelo.clases.Pedido p : pedidoList) {
            pedidoModeloObservableList.add(new PedidoModelo(p.getIdPedido(), p.getNombrePedido(), p.getEstado(), p.getUsuario())); //podemos meter to en la ObservableList
        }
        //metemos en tabla
        idIdPedido.setCellValueFactory(cellData -> cellData.getValue().getIdPedido());
        idNombrePedido.setCellValueFactory(cellData -> cellData.getValue().getNombrePedido());
        idEstado.setCellValueFactory(cellData -> cellData.getValue().getEstado());
        idUsuario.setCellValueFactory(cellData -> cellData.getValue().getUsuario());
        idTabla.setItems(pedidoModeloObservableList);
    }

    //cambio en el combo
    public void cambio(ActionEvent actionEvent) {
        //envia usuario, recoge lista normal de pedidos
        List<com.example.proyectodawfa.modelo.clases.Pedido> pedidoList = PedidosDAO.seleccionarPedidosPorUsuario(cmbUsuarios.getValue());
        pedidoModeloObservableList = FXCollections.observableArrayList();
        //tipo elem, elem, lista pedidos
        for (com.example.proyectodawfa.modelo.clases.Pedido p: pedidoList){
            pedidoModeloObservableList.add(new PedidoModelo(p.getIdPedido(),p.getNombrePedido(),p.getEstado(),p.getUsuario()));    //la lista normal pasala a la observable
        }
        //cambia los items de la tabla x los observable
        idTabla.setItems(pedidoModeloObservableList);
    }

}
