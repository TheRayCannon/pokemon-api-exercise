package com.pokemonlibrary.pokeapiassignment.pokemon;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {
    @Autowired
    private PokemonRepository PokemonRepository;

    public Iterable<Pokemon> list() {
        return PokemonRepository.findAll();
    }

    public Optional<Pokemon> findById(Long id) {
        return PokemonRepository.findById(id);
    }

    public Pokemon create(Pokemon pokemon) {
        return PokemonRepository.save(pokemon);
    }

    public Optional<Pokemon> update(Pokemon pokemon) {
        Optional<Pokemon> foundPokemon = PokemonRepository.findById(pokemon.getId());

        if (foundPokemon.isPresent()) {
            Pokemon updatedPokemon = foundPokemon.get();
            updatedPokemon.setName(pokemon.getName());

            PokemonRepository.save(updatedPokemon);
            return Optional.of(updatedPokemon);
        } else {
            return Optional.empty();
        }
    }

    public void deleteById(Long id) {
        PokemonRepository.deleteById(id);
    }
}