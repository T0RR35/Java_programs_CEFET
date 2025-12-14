package com.gpjecc.blogspot.chuvagame;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class DesktopStarter{

	public static void main (String[] args) {
		//Configuração da aplicação.
	      System.setProperty("org.lwjgl.opengl.Display.allowSoftwareOpenGL", "true");
		//Inicia a aplicação com a classe SimpleGame.
        new LwjglApplication(new SimpleGame(), "SimpleGame-LibGDX", 800, 600, false);
	}
}