package dev.sunghak.resolution_reminder.service;

import dev.sunghak.resolution_reminder.model.Account;
import dev.sunghak.resolution_reminder.model.Resolution;
import org.springframework.stereotype.Service;
import dev.sunghak.resolution_reminder.repository.ResolutionRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ResolutionService {
    private final ResolutionRepository resolutionRepository;
    private final AccountService accountService;

    public ResolutionService(ResolutionRepository resolutionRepository, AccountService accountService) {
        this.resolutionRepository = resolutionRepository;
        this.accountService = accountService;
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

    // Get
    public Optional<Resolution> getResolutionById(Long id) {
        return resolutionRepository.findById(id);
    }

    public List<Resolution> getResolutionsByAuthor(Account author) {
        return resolutionRepository.findAllByAuthor(author);
    }

    public List<Resolution> getResolutionsByAuthorId(Long authorId) {
        try {
            Account author = accountService.getAccountById(authorId);
            return resolutionRepository.findAllByAuthor(author);
        }
        catch (IllegalArgumentException e) {
            return Collections.emptyList();
        }
    }

    //Update
    public Resolution updateResolution(Resolution updatedResolution) {
        Resolution resolution = resolutionRepository.findById(updatedResolution.getResId())
                .orElseThrow(() -> new IllegalArgumentException("Resolution not found with ID: " + updatedResolution.getResId()));

        if (updatedResolution.getContent() != null) {
            resolution.setContent(updatedResolution.getContent());
        }
        if (updatedResolution.getSendDate() != null) {
            resolution.setSendDate(updatedResolution.getSendDate());
        }
        if (updatedResolution.getWrittenDate() != null) {
            resolution.setWrittenDate(updatedResolution.getWrittenDate());
        }
        if (updatedResolution.getAuthor() != null) {
            resolution.setAuthor(updatedResolution.getAuthor());
        }
        resolution.setSent(updatedResolution.isSent());

        return resolutionRepository.save(resolution);
    }

    //Delete
    public void deleteResolution(Long id) {
        Resolution resolution = resolutionRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("Resolution not found with ID: " + id));
        resolutionRepository.deleteById(id);
    }
}
