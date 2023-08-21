package edu.pe.idat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.pe.idat.model.Reserva;
import edu.pe.idat.repository.ReservaRepository;

@Service
public class ReservaService {

	private final ReservaRepository reservaRepository;
    private final DepartamentoService departamentoService;


    public ReservaService(ReservaRepository reservaRepository, DepartamentoService departamentoService) {
        this.reservaRepository = reservaRepository;
        this.departamentoService = departamentoService;
    }

    public List<Reserva> obtenerTodasLasReservas() {
        return reservaRepository.findAll();
    }

    public Optional<Reserva> obtenerReservaPorId(Long id) {
        return reservaRepository.findById(id);
    }

    public Reserva guardarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public void eliminarReservaPorId(Long id) {
        reservaRepository.deleteById(id);
    }

    public Reserva actualizarReserva(Long id, Reserva reservaActualizada) {
        Optional<Reserva> reservaExistente = reservaRepository.findById(id);

        if (reservaExistente.isPresent()) {
            Reserva reserva = reservaExistente.get();
            reserva.setFecha(reservaActualizada.getFecha());
            reserva.setActivo(reservaActualizada.isActivo());
            reserva.setUsuario(reservaActualizada.getUsuario());
            reserva.setCliente(reservaActualizada.getCliente());

            return reservaRepository.save(reserva);
        } else {
            throw new RuntimeException("No se encontró la reserva con el ID proporcionado");
        }
    }
    
    @Transactional
    public Reserva crearReserva(Reserva reserva) {
        Reserva nuevaReserva = reservaRepository.save(reserva);
        departamentoService.actualizarDisponibilidadDepartamento(reserva.getDepartamento().getId(), false);
        return nuevaReserva;
    }
	
}
