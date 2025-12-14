package Controller;

import Model.Model;

public class Controller {

    int indiceEstudante = 0;
    Model model = new Model();

    public Controller(){}

    public boolean[] testaLimites() {
        //O PRIMEIRO SE REFERE AO ENABLED DO btnAnterior, e o segundo do btnProximo
        boolean[] retorno = new boolean[2];
            if (indiceEstudante == 0) {
            //btnAnterior.setEnabled(false);
            //btnProximo.setEnabled(true);
            retorno[0] = false;
            retorno[1] = true;
            return retorno;

        } else if (indiceEstudante == (model.getAllEstudantes()).size() - 1) {
            //btnAnterior.setEnabled(true);
            //btnProximo.setEnabled(false);
            retorno[0] = true;
            retorno[1] = false;
            return retorno;
        } else {
            //btnAnterior.setEnabled(true);
            //btnProximo.setEnabled(true);
            retorno[0] = true;
            retorno[1] = true;
            return retorno;
        }
    }

    public int getIndiceEstudante(){
        return indiceEstudante;
    }

    public void aumentaIndiceEstudante(){
        indiceEstudante++;
    }

    public void diminuiIndiceEstudante(){
        indiceEstudante--;
    }

    public String getUmEstudante(){
        return model.getUmEstudante(indiceEstudante);
    }
}
