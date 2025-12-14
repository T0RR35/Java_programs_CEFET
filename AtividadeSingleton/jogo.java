import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class jogo {
	// Tamanho da janela
	public static final int LARGURA = 640;
	public static final int ALTURA = 480;

	public static void main(String args[]) {
		JogoPainel jogoPainel = new JogoPainel();
		JFrame jogo = new JFrame("Tutorial");
		jogo.add(jogoPainel);
		jogo.pack();
		jogo.setSize(LARGURA, ALTURA);
		jogo.setResizable(false);
		jogo.setVisible(true);
		jogo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class JogoPainel extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	// Tamanho da janela - tamanho das bordas (640-18 = 625)
	public static final int LARGURA = jogo.LARGURA - 18;
	// Tamanho da janela - tamanho das bordas (480-38 = 445)
	public static final int ALTURA = jogo.ALTURA - 38;
	private Thread animacao;

	private int tempoEspera = 10;
	private boolean jogando = false;

	// Define informações da janela.
	public JogoPainel() {
		// cor de fundo.
		setBackground(Color.BLACK);
		setFocusable(true);
		Movel.getInstance();

		Movel.getInstance().setParametros(new Dimension(30, 30), 100, 300, 10, 0, Color.RED);
		Movel.getInstance().setParametros(null, null, null, null, null, null);
	}

	// Controle de início do jogo.
	public void addNotify() {
		super.addNotify();
		iniciarJogo();
	}

	// Função que da start nas funções de in�cio do jogo
	private void iniciarJogo() {
		if (animacao == null || !jogando) {
			animacao = new Thread(this);
			animacao.start();

		}
	}

	@Override
	public void run() {
		jogando = true;
		/*
		 * Loop do jogo. Aqui as coisas acontecem.
		 */
		while (jogando) {
			/*
			 * Coloque aqui todas as ações que queira que sejam executadas a cada loop do
			 * jogo
			 */
			Movel.getInstance().mover();
			repaint();
			/* fim ações para testes */
			try {
				Thread.sleep(tempoEspera);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.exit(0);
	}

	/* Função que desenha o fundo do painel . */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Movel.getInstance().paintComponent(g);
	}
}

class Movel {

	Dimension dimension;
	private int x, y, velX, velY;
	private Color cor;

    static private Movel instance = null;

	public void mover() {
		// Bora quebra um pouco a cabe�a.

		if (x <= 0) {
			velX *= -1;
		} else if (x >= JogoPainel.LARGURA - dimension.width / 2) {
			velX *= -1;
		}

		if (y <= 0) {
			velY *= -1;
		} else if (y >= JogoPainel.ALTURA - dimension.height / 2) {
			velY *= -1;
		}

		x += velX;
		y -= velY;

	}

    public static Movel getInstance(){
        if(instance == null)instance = new Movel();
        return instance;
    }

	/**
	 * Método set para devinir todos os valores do móvel.
	 * 
	 * @param dimension - dimensões largura e altura do móvel. null gera valor
	 *                  aleatorio
	 * @param x         - Posição x do móvel. null gera valor aleatorio
	 * @param y         - Posição y do móvel. null gera valor aleatorio
	 * @param velX      - Velocidade x do móvel. null gera valor aleatorio
	 * @param velY      - Velocidade y do móvel. null gera valor aleatorio
	 * @param cor       - Cor do móvel. null gera valor aleatorio
	 */
	public void setParametros(Dimension dimension, Integer x, Integer y, Integer velX, Integer velY, Color cor) {
		Random rand = new Random();
		this.dimension = (dimension != null ? dimension
				: new Dimension(rand.nextInt(JogoPainel.LARGURA / 10), rand.nextInt(JogoPainel.ALTURA / 10)));
		this.x = (x != null ? x : rand.nextInt(JogoPainel.LARGURA));
		this.y = (y != null ? y : rand.nextInt(JogoPainel.ALTURA));
		this.velX = (velX != null ? velX : rand.nextInt(10));
		this.velY = (velY != null ? velY : rand.nextInt(10));
		this.cor = (cor != null ? cor : new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat()));
	}

	public void paintComponent(Graphics g) {
		// Define a cor
		g.setColor(cor);
		// Pinta o circulo.
		g.fillOval(x, y, dimension.width, dimension.height);
		g.setColor(Color.WHITE);
		g.drawOval(x, y, dimension.width, dimension.height);

	}
}