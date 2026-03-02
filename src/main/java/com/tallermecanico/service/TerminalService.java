package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateTerminalDto;
import com.tallermecanico.dto.request.UpdateTerminalDto;
import com.tallermecanico.entity.Terminal;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.TerminalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TerminalService {

    private final TerminalRepository terminalRepository;

    public TerminalService(TerminalRepository terminalRepository) {
        this.terminalRepository = terminalRepository;
    }

    @Transactional
    public Terminal create(CreateTerminalDto dto) {
        // Validar terminal único
        if (dto.getTerminal() != null && terminalRepository.existsByTerminal(dto.getTerminal())) {
            throw new DuplicateResourceException("Terminal", "terminal", dto.getTerminal());
        }

        // Validar prefijo único
        if (dto.getPrefijo() != null && terminalRepository.existsByPrefijo(dto.getPrefijo())) {
            throw new DuplicateResourceException("Terminal", "prefijo", dto.getPrefijo());
        }

        Terminal terminal = new Terminal();
        terminal.setTerminal(dto.getTerminal());
        terminal.setPrefijo(dto.getPrefijo());

        return terminalRepository.save(terminal);
    }

    @Transactional(readOnly = true)
    public List<Terminal> findAll() {
        return terminalRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Terminal findById(Integer id) {
        return terminalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Terminal", "id", id));
    }

    @Transactional
    public Terminal update(Integer id, UpdateTerminalDto dto) {
        Terminal terminal = findById(id);

        // Validar terminal único (excluyendo el actual)
        if (dto.getTerminal() != null &&
            terminalRepository.existsByTerminalAndIdTerminalNot(dto.getTerminal(), id)) {
            throw new DuplicateResourceException("Terminal", "terminal", dto.getTerminal());
        }

        // Validar prefijo único (excluyendo el actual)
        if (dto.getPrefijo() != null &&
            terminalRepository.existsByPrefijoAndIdTerminalNot(dto.getPrefijo(), id)) {
            throw new DuplicateResourceException("Terminal", "prefijo", dto.getPrefijo());
        }

        if (dto.getTerminal() != null) {
            terminal.setTerminal(dto.getTerminal());
        }
        if (dto.getPrefijo() != null) {
            terminal.setPrefijo(dto.getPrefijo());
        }

        return terminalRepository.save(terminal);
    }

    @Transactional
    public void delete(Integer id) {
        Terminal terminal = findById(id);
        terminalRepository.delete(terminal);
    }
}
