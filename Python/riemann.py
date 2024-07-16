import matplotlib.pyplot as plt
import numpy as np
import mpmath

# Definición de la función zeta de Riemann usando mpmath
def zeta(s):
    return mpmath.zeta(s)

# Ejemplo: Cálculo de la función zeta de Riemann en s=2
s = 2
resultado = zeta(s)
resultado

# Rango de valores para t
t_values = np.linspace(0, 50, 400)
zeta_values = [zeta(0.5 + 1j * t) for t in t_values]

# Graficar la parte real e imaginaria de zeta(0.5 + it)
plt.figure(figsize=(12, 6))
plt.subplot(2, 1, 1)
plt.plot(t_values, [z.real for z in zeta_values], label='Re(ζ(0.5 + it))')
plt.title('Parte Real de ζ(0.5 + it)')
plt.legend()

plt.subplot(2, 1, 2)
plt.plot(t_values, [z.imag for z in zeta_values], label='Im(ζ(0.5 + it))', color='orange')
plt.title('Parte Imaginaria de ζ(0.5 + it)')
plt.legend()

plt.tight_layout()
plt.show()
