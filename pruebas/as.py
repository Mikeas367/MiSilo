import sys

from PyQt6.QtGui import QFont
from PyQt6.QtWidgets import QApplication, QWidget, QLabel, QLineEdit


class VentanaVacia(QWidget):
    def __init__(self):
        super().__init__()
        self.inicializar()

    def inicializar(self):
        self.setGeometry(100, 100, 250, 250)
        self.setWindowTitle("Mi Primer Ventana con pyqt6")
        self.generar_label()
        self.show()

    def generar_label(self):
        # Titulo
        cajatxt = QLabel(self)
        cajatxt.setText("Usuario")
        cajatxt.setFont(QFont('Arial', 10))
        cajatxt.move(20, 54)
        # Caja de Texto
        # Se le pone el self ya que si se quiere llamar a esta variable de otro lado
        # y si no ponemos el self va a quedar como variable de la clase
        self.cajatxt_input = QLineEdit(self)
        self.cajatxt_input.resize(250, 24)
        self.cajatxt_input.move(20, 70)
        # Titulo
        cajatxt2 = QLabel(self)
        cajatxt2.setText("Contraseña")
        cajatxt2.setFont(QFont('Arial', 10))
        cajatxt2.move(20, 100)
        self.cajatxt_input2 = QLineEdit(self)
        self.cajatxt_input2.resize(250, 24)
        self.cajatxt_input2.move(20, 120)


if __name__ == '__main__':
    app = QApplication(sys.argv)
    ventana = VentanaVacia()
    sys.exit(app.exec())
