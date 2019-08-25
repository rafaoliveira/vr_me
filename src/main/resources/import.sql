INSERT INTO Cliente(id, nome, cartao, primeiroAcesso, cartaoBloqueado, proximoBeneficio, saldo, valorProximoBeneficio) VALUES (1, 'Carlos Bazuca', 2469, 	true, false, '30 de agosto', 430, 1200);
BEGIN;
SELECT setval(pg_get_serial_sequence('cliente_pkey','id'), coalesce(max("id"), 1), max(50) IS NOT null) FROM Cliente;
COMMIT;