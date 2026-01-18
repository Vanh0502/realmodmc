package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashSet;
import java.util.Set;

public class TreePhysics {

    public static void breakTree(World world, BlockPos start) {
        Set<BlockPos> visited = new HashSet<>();
        breakRecursive(world, start, visited, 0);
    }

    private static void breakRecursive(World world, BlockPos pos, Set<BlockPos> visited, int depth) {
        if (depth > 20 || visited.contains(pos)) return;

        Block block = world.getBlockState(pos).getBlock();
        if (!BlockTags.LOGS.contains(block)) return;

        visited.add(pos);
        world.destroyBlock(pos, true);

        breakRecursive(world, pos.above(), visited, depth + 1);
    }
}
