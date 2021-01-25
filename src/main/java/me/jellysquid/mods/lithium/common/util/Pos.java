package me.jellysquid.mods.lithium.common.util;

import net.minecraft.util.math.ChunkSectionPos;
import net.minecraft.world.HeightLimitView;

public class Pos {

    public static class BlockCoord {
        public static int getYSize(HeightLimitView view) {
            return view.getSectionCount();
        }
        public static int getMinY(HeightLimitView view) {
            return view.getBottomSectionLimit();
        }
        public static int getMaxYInclusive(HeightLimitView view) {
            return view.getTopHeightLimit() - 1;
        }
        public static int getMaxYExclusive(HeightLimitView view) {
            return view.getTopHeightLimit();
        }

        public static int getMaxInSectionCoord(int sectionCoord) {
            return 15 + getMinInSectionCoord(sectionCoord);
        }

        public static int getMaxYInSectionIndex(HeightLimitView view, int sectionIndex){
            return getMaxInSectionCoord(SectionYCoord.fromSectionIndex(view, sectionIndex));
        }

        public static int getMinInSectionCoord(int sectionCoord) {
            return ChunkSectionPos.getBlockCoord(sectionCoord);
        }

        public static int getMinYInSectionIndex(HeightLimitView view, int sectionIndex) {
            return getMinInSectionCoord(SectionYCoord.fromSectionIndex(view, sectionIndex));
        }
    }

    public static class ChunkCoord {
        public static int fromBlockCoord(int blockCoord) {
            return ChunkSectionPos.getSectionCoord(blockCoord);
        }

        public static int fromBlockSize(int i) {
            return i >> 4; //same method as fromBlockCoord, just be clear about coord/size semantic difference
        }
    }

    public static class SectionYCoord {
        public static int getNumYSections(HeightLimitView view) {
            return view.getSections();
        }
        public static int getMinYSection(HeightLimitView view) {
            return view.getMinimumSection();
        }
        public static int getMaxYSectionInclusive(HeightLimitView view) {
            return view.getTopSectionLimit() - 1;
        }
        public static int getMaxYSectionExclusive(HeightLimitView view) {
            return view.getTopSectionLimit();
        }

        public static int fromSectionIndex(HeightLimitView view, int sectionCoord) {
            return sectionCoord + SectionYCoord.getMinYSection(view);
        }
        public static int fromBlockCoord(int blockCoord) {
            return ChunkSectionPos.getSectionCoord(blockCoord);
        }
    }

    public static class SectionYIndex {
        public static int getNumYSections(HeightLimitView view) {
            return view.getSections();
        }
        public static int getMinYSectionIndex(HeightLimitView view) {
            return 0;
        }
        public static int getMaxYSectionIndexInclusive(HeightLimitView view) {
            return view.getSections() - 1;
        }
        public static int getMaxYSectionIndexExclusive(HeightLimitView view) {
            return view.getSections();
        }


        public static int fromSectionCoord(HeightLimitView view, int sectionCoord) {
            return sectionCoord - SectionYCoord.getMinYSection(view);
        }
        public static int fromBlockCoord(HeightLimitView view, int blockCoord) {
            return fromSectionCoord(view, ChunkSectionPos.getSectionCoord(blockCoord));
        }
    }
}
