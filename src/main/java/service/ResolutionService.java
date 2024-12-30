package service;

import model.Account;
import model.Resolution;
import repository.ResolutionRepository;

import java.util.Optional;

public class ResolutionService {
    private final ResolutionRepository resolutionRepository;

    public ResolutionService(ResolutionRepository resolutionRepository) {
        this.resolutionRepository = resolutionRepository;
    }

    // Create
    public Resolution createResolution(Resolution resolution) {
        if (resolution == null || resolution.getAuthor() == null || resolution.getContent() == null || resolution.getSendDate() == null || resolution.getWrittenDate() == null)
            throw new IllegalArgumentException("Invalid resolution");
        if (resolution.getSendDate().isBefore(resolution.getWrittenDate())) {
            throw new IllegalArgumentException("SendDate must be after WrittenDate");
        }
        return resolutionRepository.save(resolution);
    }
    public Optional<Resolution> getResolutionsByAuthor(Account author) {
        return resolutionRepository.findByAuthor(author);
    }
    //Update
    public boolean updateResolution(Resolution resolution) {
        if (resolutionRepository.existsById(resolution.getResId())) {
            resolutionRepository.save(resolution);
            return true;
        }
        return false;
    }
    //Delete
    public boolean deleteResolution(Resolution resolution) {
        if (resolutionRepository.existsById(resolution.getResId())) {
            resolutionRepository.deleteById(resolution.getResId());
            return true;
        }
        return false;
    }
}
