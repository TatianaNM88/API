package com.informatorio.emprendimientos.converter;

import java.time.LocalDateTime;
import com.informatorio.emprendimientos.dto.VotoDTO;
import com.informatorio.emprendimientos.entity.Voto;
import com.informatorio.emprendimientos.repository.EmprendimientoRepository;
import com.informatorio.emprendimientos.repository.UsuarioRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class VotoDTOVotoConverter implements Converter<VotoDTO, Voto> {
    public VotoDTOVotoConverter(EmprendimientoRepository emprendimientoRepository,
                                UsuarioRepository usuarioRepository) {
    }
    @Override
    public Voto convert(VotoDTO votoDto) {
        Voto voto = new Voto();
        voto.setGenerado(votoDto.getGenerado());
        voto.setUsuarioId(votoDto.getUsuarioId());
        voto.setEmprendimientoId(votoDto.getEmprendimientoId());
        voto.setFechaDeCreacion(LocalDateTime.now());
        return voto;
    } 
}