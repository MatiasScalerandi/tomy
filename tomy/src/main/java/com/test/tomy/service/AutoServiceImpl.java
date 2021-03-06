package com.test.tomy.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.tomy.constant.ErrorConstants;
import com.test.tomy.dto.AutoDTO;
import com.test.tomy.exception.AutoException;
import com.test.tomy.model.Auto;
import com.test.tomy.repository.AutoRepository;
import com.test.tomy.util.ModelMapperProductUtil;

@Service
public class AutoServiceImpl implements AutoService {

	@Autowired
	private AutoRepository autoDAO;

	@Override
	public List<AutoDTO> obtenerAutos() throws AutoException {
		List<Auto> listaAutoBD = autoDAO.findAll();
		List<AutoDTO> listaAutoDTO = new ArrayList<>();
		
		if (listaAutoBD.isEmpty()) {
			throw new AutoException(ErrorConstants.ERROR_HANDLER);
		}
		
		listaAutoBD.forEach(l -> {
			try {
				listaAutoDTO.add(ModelMapperProductUtil.convertToDTO(l));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		});
		return listaAutoDTO;
	}

	@Override
	public AutoDTO guardarAuto(AutoDTO autoDTO) throws ParseException, AutoException {
		Optional<AutoDTO> autoOp = Optional.ofNullable(autoDTO);
		autoOp.orElseThrow(() -> new AutoException(ErrorConstants.ERROR_HANDLER));
		
		Auto autoBD = new Auto();
		try {
			if (autoOp.isPresent()) {
				autoBD = ModelMapperProductUtil.convertToEntity(autoDTO);
				Auto autoDB = autoDAO.save(autoBD);
				if (autoDB == null) {
					throw new AutoException(ErrorConstants.ERROR_HANDLER);
				}
			}
		} catch (AutoException e) {
			throw new AutoException(ErrorConstants.ERROR_HANDLER);
		}
		AutoDTO autoResponse = ModelMapperProductUtil.convertToDTO(autoBD);
		return autoResponse;
	}

	@Override
	public void borrarAuto(Long id) {
		autoDAO.deleteById(id);

	}

	@Override
	public List<AutoDTO> ordenamiento(Integer ordenar) throws AutoException{

		List<AutoDTO> listaDTO = new ArrayList<>();
		List<Auto> listaAutoBD = autoDAO.findAll();

		if (!listaAutoBD.isEmpty()) {
			listaAutoBD.forEach(l -> {
				try {
					listaDTO.add(ModelMapperProductUtil.convertToDTO(l));

					if (ordenar != null && ordenar <= 2) {
						switch (ordenar) {
						case 0:
							Collections.sort(listaDTO, (x, y) -> x.getDominio().compareToIgnoreCase(y.getDominio()));
							break;
						case 1:
							Collections.sort(listaDTO, (x, y) -> x.getMarca().compareToIgnoreCase(y.getMarca()));
							break;
						case 2:
							Collections.sort(listaDTO, (x, y) -> x.getModelo().compareToIgnoreCase(y.getModelo()));
							break;

						}
					}
					
				} catch (ParseException e) {
					e.printStackTrace();
				}
			});
		}

		return listaDTO;
	}

}
